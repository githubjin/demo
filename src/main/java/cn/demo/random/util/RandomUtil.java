package cn.demo.random.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Utility class for generating random Strings. 
 */
public class RandomUtil {

	private static final int DEF_COUNT = 20;
	
	private RandomUtil() {
	}
	/**
	 * 生成一个密码
	 * @return
	 */
	public static String generatePassword() {
		return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
	}
	
	/**
	 *  生成一个激活密码
	 * @return
	 */
	public static String generateActivationKey() {
		return RandomStringUtils.randomNumeric(DEF_COUNT);
	}
	/**
	 *  生成一个重置密码
	 * @return
	 */
	public static String generateResetKey() {
		return RandomStringUtils.randomNumeric(DEF_COUNT);
	}
}
