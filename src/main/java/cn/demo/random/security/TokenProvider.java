package cn.demo.random.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.demo.random.config.AppProperties;

@Component
public class TokenProvider {

	private AppProperties appProperties;
	private ObjectMapper objectMapper;
	private final MacSigner hmac;

	@Autowired
	public TokenProvider(AppProperties appProperties, ObjectMapper objectMapper) {
		this.appProperties = appProperties;
		this.objectMapper = objectMapper;
		this.hmac = new MacSigner(appProperties.getJwt().getHmacKey());
	}

	public String createToken(UserDetails userDetails) throws JsonProcessingException {
		long expires = System.currentTimeMillis()
				+ 1000L * Integer.parseInt(appProperties.getJwt().getTokenValidityInSeconds());
		List<String> roles = new ArrayList<String>();
		userDetails.getAuthorities().forEach((it) -> {
			roles.add(it.getAuthority());
		});
		Token token = new Token(appProperties.getJwt().getIssuer(), expires, userDetails.getUsername(), roles);
		Jwt jwt = JwtHelper.encode(this.objectMapper.writeValueAsString(token), hmac);
		return jwt.getEncoded();
	}

	public String getUserNameFromToken(String authToken) throws JsonParseException, JsonMappingException, IOException {
		if (null == authToken) {
			return null;
		}
		Jwt decode = JwtHelper.decode(authToken);
		Token readValue = this.objectMapper.readValue(decode.getClaims(), Token.class);
		return readValue.getUserId();
	}

	public boolean validateToken(String authToken) throws JsonParseException, JsonMappingException, IOException {
		Jwt decode = JwtHelper.decode(authToken);
		Token readValue = this.objectMapper.readValue(decode.getClaims(), Token.class);
		return readValue.getExp() >= System.currentTimeMillis();
	}
}
