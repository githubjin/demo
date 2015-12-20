package cn.demo.random.config;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.thymeleaf.TemplateEngine;

@Configuration
public class MailConfiguration {

	private final Logger logger = LoggerFactory.getLogger(MailConfiguration.class);
	
	/**
	 *  Using Thymeleaf to create email messages
	 * @return
	 */
	@Bean
	public TemplateEngine templateEngine(){
		TemplateEngine templateEngine = new TemplateEngine();
//		templateEngine.settem
		return new TemplateEngine();
	}
	
	@Bean
	@Description("Spring mail message resolver")
	public MessageSource emailMessageSource() {
		logger.info("loading non-reloadable mail messages resorces");
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/mails/messages/messages");
		messageSource.setDefaultEncoding(CharEncoding.UTF_8);
		return messageSource;
	}
}
