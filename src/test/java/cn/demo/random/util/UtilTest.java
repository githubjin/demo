package cn.demo.random.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class UtilTest {
	
	private final Logger logger = LoggerFactory.getLogger(UtilTest.class);

	@Test
	public void randomUtilTest(){
		String generatePassword = RandomUtil.generatePassword();
		String generateActivationKey = RandomUtil.generateActivationKey();
		String generateResetKey = RandomUtil.generateResetKey();
		
		assertThat(generatePassword, notNullValue());
		assertThat(generateActivationKey, notNullValue());
		assertThat(generateResetKey, notNullValue());
		
		assertThat(generatePassword.length(), equalTo(20));
		assertThat(generateActivationKey.length(), equalTo(20));
		assertThat(generateResetKey.length(), equalTo(20));
		
		logger.info("-------{}--------{}---------{}----------", generatePassword, generateActivationKey, generateResetKey);
	}
	
}
