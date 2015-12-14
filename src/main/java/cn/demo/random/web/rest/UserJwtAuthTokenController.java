package cn.demo.random.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import cn.demo.random.security.TokenProvider;

@RestController
@RequestMapping("/api")
public class UserJwtAuthTokenController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenProvider tokenProvider;

	@Timed
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authorize(@RequestParam String username, @RequestParam String password) throws JsonProcessingException {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authenticate = this.authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
		return this.tokenProvider.createToken(userDetails);
	}
	
}
