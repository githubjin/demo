package cn.demo.random.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/**
 *    认证是由AuthenticationManager来管理的，但是真正进行认证的是AuthenticationManager中定义的AuthenticationProvider。
 *    AuthenticationManager中可以定义有多个AuthenticationProvider。当我们使用authentication-provider
 *    元素来定义一个AuthenticationProvider时，如果没有指定对应关联的AuthenticationProvider对象，
 *    Spring Security默认会使用DaoAuthenticationProvider。DaoAuthenticationProvider
 *    在进行认证的时候需要一个UserDetailsService来获取用户的信息UserDetails，其中包括用户名、密码和所拥有的权限等。
 *    所以如果我们需要改变认证的方式，我们可以实现自己的AuthenticationProvider；
 *    如果需要改变认证的用户信息来源，我们可以实现UserDetailsService。
 * @author Yo
 *
 */
@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

	private final Logger logger = LoggerFactory.getLogger(AuthenticationProvider.class);
	
	private PasswordEncoder passwordEncoder;
	private UserDetailsService userDetailsServices;
	
	@Autowired
	public AuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailService userDetailsServices) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsServices = userDetailsServices;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		String login = token.getName();
		UserDetails user = userDetailsServices.loadUserByUsername(login);
		if(user == null) {
			throw new UsernameNotFoundException("User does not exists");
		}
		String password = user.getPassword();
		String tokenPassword = (String)token.getCredentials();
		if(!passwordEncoder.matches(tokenPassword, password)) {
			throw new BadCredentialsException("Invalid username/password");
		}
		return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
