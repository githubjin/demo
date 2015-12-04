package cn.demo.random.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/mail.properties")
public class MailConfiguration {
	
}
