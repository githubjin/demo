package cn.demo.random.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {

	private final static String BEARER_TOKEN_HEADER_NAME = "bearer-token";

	private UserDetailsService detailService;
	private TokenProvider tokenProvider;

	public JwtFilter(UserDetailsService detailService, TokenProvider tokenProvider) {
		this.detailService = detailService;
		this.tokenProvider = tokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String bearerToken = httpServletRequest.getHeader(BEARER_TOKEN_HEADER_NAME);
			if (StringUtils.hasText(bearerToken)) {
				if (this.tokenProvider.validateToken(bearerToken)) {
					String userId = this.tokenProvider.getUserNameFromToken(bearerToken);
					UserDetails details = this.detailService.loadUserByUsername(userId);
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details,
							details.getPassword(), details.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(token);
				}
				// UserDetails details = new User(userId.trim().toLowerCase(),
				// "888888", grantedAuthorities);
			}
			chain.doFilter(request, response);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
