package cn.demo.random.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import cn.demo.random.rbac.mapper.RbacPermissionMapper;
import cn.demo.random.rbac.model.RolePermissionResources;
import cn.demo.random.rbac.service.IRbacService;
import cn.demo.random.security.AuthenticationProvider;
import cn.demo.random.security.JwtConfigurer;
import cn.demo.random.security.TokenProvider;

/**
 * 1.@EnableWebSecurity extends WebSecurityConfigurerAdapter 
 *   off auto-config ompletely httpsecurity and authentication manager
 * 2. off or on with security.*
 *     To  override  the  access  rules  without  changing  any  other
 *	auto-configured  features  add  a  @Bean of  type  WebSecurityConfigurerAdapter with 
 *  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER) */
/**
 * The basic features you get out of the box in a web auto-config application are:
	• An  AuthenticationManager bean  with  in-memory  store  and  a  single  user  (see
	SecurityProperties.Userfor the properties of the user).
	• Ignored (insecure) paths for common static resource locations (/css/**,  /js/**,  /images/ **and ** /favicon.ico).
	• HTTP Basic security for all other endpoints.
	• Security  events  published  to  Spring’s  ApplicationEventPublisher (successful  and
	unsuccessful authentication and access denied).
	• Common low-level features (HSTS, XSS, CSRF, caching) provided by Spring Security are on by
	default.
 * @author Yo
 *
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
public class SecurityConfiguration {
	
	private final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Autowired
	private TokenProvider tokenProvider;
	
	/*@Autowired
    private RbacPermissionMapper rbacPermissionMapper;
	
	@Autowired
	private FilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;*/
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider)
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	@Bean
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	public WebSecurityConfigurerAdapter applicationSecurityConfiguration(IRbacService rbacService){
		
		// 查询数据库
		Optional<LinkedHashMap<String,String>> loadResource = this.loadResource(rbacService);
		logger.info("---------------------WebsecurityConfigurerAdapter rolePermissionResources isPresent: {} and length : {} --------------------", loadResource.isPresent(), loadResource.get().size());
		return new WebSecurityConfigurerAdapter(){

//			@Override
//			public void configure(WebSecurity web) throws Exception {
//				web.ignoring()
//					.antMatchers("/script/**/*.{js.html}")
//					.antMatchers("/bower_components/**")
//					.antMatchers("/i18n/**")
//					.antMatchers("/assets/**")
//					.antMatchers("/swagger-ui/index.html")
//		            .antMatchers("/test/**");
//			}

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http
					.csrf()
					.disable()
					.headers()
					.frameOptions()
					.disable()
				.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
					.authorizeRequests()
		            .antMatchers("/api/register").permitAll()
		            .antMatchers("/api/activate").permitAll()
		            .antMatchers("/api/authenticate").permitAll()
		            .antMatchers("/api/account/reset_password/init").permitAll()
		            .antMatchers("/api/account/reset_password/finish").permitAll();
				
				if(loadResource.isPresent()){
					LinkedHashMap<String, String> map = loadResource.get();
					for(Map.Entry<String, String> entry : map.entrySet()){
						http.authorizeRequests().antMatchers(entry.getKey()).hasAnyAuthority(entry.getValue().split(","));
					}
				}
				http.authorizeRequests().antMatchers("/api/**").authenticated();
				http.apply(securityConfigurerAdapter());
			}
		};
	}
	
	private JwtConfigurer securityConfigurerAdapter() {
		return new JwtConfigurer(this.tokenProvider, this.userDetailsService);
	}
	
	// #pricainal sel
	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension(){
		return new SecurityEvaluationContextExtension();
	}
	
	//close auto configuration authentication manager completely
	/*@Autowired
	public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder){
		
	}*/
	
	/**
	 *  查询资源与角色的对应关系
	 * @param repository
	 * @return
	 */
    private Optional<LinkedHashMap<String, String>> loadResource(IRbacService rbacService) {
    	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        List<RolePermissionResources> rolePermissionResources = rbacService.listAllPermissionsBindedToRoles();
        if(!rolePermissionResources.isEmpty()){
        	for(RolePermissionResources pr : rolePermissionResources){
        		if(map.containsKey(pr.getPsUrl())) {
                    String s = map.get(pr);
                    map.put((String)pr.getPsUrl(), s + "," + pr.getRoleName());
                }else{
                    map.put((String)pr.getPsUrl(), (String)pr.getRoleName());
                }
        	}
        }
        return Optional.ofNullable(map);
    }
	
}
