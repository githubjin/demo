package cn.demo.random.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

public class ContextReloadListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ContextReloadListener.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("##------------------------------ContextRefreshedEvent---------------------------");
		ApplicationContext applicationContext = event.getApplicationContext();
		int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String beanName : beanDefinitionNames){
			logger.info("#-----bean definition name: {}", beanName);
		}
		Environment environment = applicationContext.getEnvironment();
		logger.info("Environment property log.path : {}", environment.containsProperty("log.path"));
		logger.info("Environment property log.file : {}", environment.containsProperty("log.file"));
		logger.info("Environment property log.level : {}", environment.containsProperty("log.level"));
	}

}
