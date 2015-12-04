package cn.demo.random.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
public class SecurityConfiguration {

	@Bean
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	public WebSecurityConfigurerAdapter applicationSecurityConfiguration(){
		return new WebSecurityConfigurerAdapter(){

			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				// TODO Auto-generated method stub
				super.configure(auth);
			}

			@Override
			public void configure(WebSecurity web) throws Exception {
				// TODO Auto-generated method stub
				super.configure(web);
			}

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				// TODO Auto-generated method stub
				super.configure(http);
			}
			
		};
	}
	
}
