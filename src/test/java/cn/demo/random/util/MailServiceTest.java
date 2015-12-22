package cn.demo.random.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.demo.random.Application;
import cn.demo.random.rbac.domain.RbacUser;

@ActiveProfiles(profiles = "dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MailServiceTest {

	@Autowired
	private MailService mailService;
	
	private RbacUser user;
	private String baseUrl;
	
	@Before
	public void before(){
		baseUrl = "http://www.baidu.com";
		user = new RbacUser();
		user.setEmail("1252833909@qq.com");
		user.setActivationKey(RandomUtil.generateActivationKey());
		user.setUserName("yoman");
		user.setLangKey("cn");
	}
	
	@Test
	public void sendMail(){
		mailService.sendActivatioEmail(user, baseUrl);
	}
	
}
