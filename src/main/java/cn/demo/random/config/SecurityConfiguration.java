package cn.demo.random.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

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
	
	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private FilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	@Bean
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	public WebSecurityConfigurerAdapter applicationSecurityConfiguration(){
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
					.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
						@Override
						public <O extends FilterSecurityInterceptor> O postProcess(O object) {
							object.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
							return object;
						}
					}).and().authorizeRequests().anyRequest().permitAll()
				.and()
					.apply(securityConfigurerAdapter());
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
	
}
