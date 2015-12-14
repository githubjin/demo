package cn.demo.random.security;

import java.io.IOException;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TokenProviderTest {

	
	private String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZW1vLWRldiIsImV4cCI6MTQ1MDA3NjcwNzI5MSwidXNlcklkIjoiSm9zaCIsInJvbGVzIjpbIkFETUlOIl19.5wfY51x6HfETC0_DjQJgGJiVFWUB_2PPJeTiQzbTZrM";
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException{
		Jwt decode = JwtHelper.decode(token);
		ObjectMapper objectMapper = new ObjectMapper();
		String claims = decode.getClaims();
		System.out.println(claims);
		Token readValue = objectMapper.readValue(claims, Token.class);
		System.out.println(readValue.getUserId());
	}
	
}
