package cn.demo.random.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private TokenProvider tokenProvider;
	private UserDetailsService detailsService;
	
	public JwtConfigurer(TokenProvider tokenProvider, UserDetailsService detailsService) {
		this.tokenProvider = tokenProvider;
		this.detailsService = detailsService;
	}



	@Override
	public void configure(HttpSecurity builder) throws Exception {
		JwtFilter customFilter = new JwtFilter(detailsService, tokenProvider);
		builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
	
}
