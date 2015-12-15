package cn.demo.random.config;

import javax.annotation.PostConstruct;
import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.demo.random.interceptor.LogbackInterceptor;

@Configuration
public class MvcConfiguration {
	
	private final Logger logger = LoggerFactory.getLogger(MvcConfiguration.class);
	
	@Autowired
	private LogbackInterceptor logbackInterceptor;

	/**
	 * If you want to keep Spring Boot MVC features, and you just want to add additional MVC configuration (
	 * interceptors, formatters, view controllers etc.) you can add your own @Bean of type WebMvcConfigurerAdapter, 
	 * but without @EnableWebMvc.
	 * @return
	 */
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurationAdapter(){
		return new WebMvcConfigurerAdapter(){
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				super.addInterceptors(registry);
				registry.addInterceptor(logbackInterceptor).addPathPatterns("/api/*");
				logger.info("************************************Adding interceptors******************************************");
			}

			/**
			 * custom static resource handler
			 */
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				super.addResourceHandlers(registry);
				registry.addResourceHandler("/*").addResourceLocations("classpath:/public/");
			}
			
		};
	}
	
	/*@Autowired
	@Qualifier("dispatcherServletRegistration")
	private ServletRegistrationBean servletRegistrationBean;
	
	@Autowired
	private MultipartResolver multipartResolver;
	
	@PostConstruct
	private void logMultipartProperties(){
		MultipartConfigElement multipartConfig = servletRegistrationBean.getMultipartConfig();
		logger.info("----------------------- MultipartResolver type: {} -----------------------", multipartResolver.getClass());
		logger.info("----------------------- MultipartConfigElement properties : {}, {}, {}, {} -----------------------", multipartConfig.getMaxRequestSize(), 
				multipartConfig.getFileSizeThreshold(), multipartConfig.getLocation(), multipartConfig.getMaxFileSize());
	}*/
	
}
