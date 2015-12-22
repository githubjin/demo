package cn.demo.random.config;

import java.util.Set;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfiguration {

	private final Logger logger = LoggerFactory.getLogger(ThymeleafConfiguration.class);
	
	/**
	 *  Using Thymeleaf to create email messages
	 * @return SpringTemplateEngine
	 */
	@Bean
	public SpringTemplateEngine templateEngine(Set<ITemplateResolver> resolvers) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolvers(resolvers);
		return engine;
	}
	
	@Bean
	@Description("Thymeleaf template resolver serving HTML 5 emails")
	public ClassLoaderTemplateResolver emailTemplateResolver() {
		DefaultTemplateResolverConfiguration s = null;
		ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
		emailTemplateResolver.setPrefix("mail/");
		emailTemplateResolver.setSuffix(".html");
		emailTemplateResolver.setTemplateMode("HTML5");
		emailTemplateResolver.setCharacterEncoding(CharEncoding.UTF_8);
		emailTemplateResolver.setOrder(1);
		return emailTemplateResolver;
	}
}
