package cn.demo.random.jwt;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	private final Logger logger = LoggerFactory.getLogger(PasswordEncoderTest.class);
	
	@Test
	public void test(){
		
		BCryptPasswordEncoder encodet = new BCryptPasswordEncoder();
		String encodedPassword = encodet.encode("admin");
		logger.info(encodedPassword);
		
	}
	
}
