package cn.demo.random.config;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
public class LocaleConfiguration implements EnvironmentAware{

    private final Logger logger = LoggerFactory.getLogger(LocaleConfiguration.class);
    private RelaxedPropertyResolver propertyResolver;

    @Bean
    @Description("Spring mail message resolver")
    public MessageSource messageSource() {
        logger.info("loading non-reloadable mail messages resources");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/i18n/messages");
        messageSource.setDefaultEncoding(CharEncoding.UTF_8);
        messageSource.setCacheSeconds(this.propertyResolver.getProperty("cache-second", Integer.class, -1));
        return messageSource;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.messages");
    }
}
