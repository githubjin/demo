package cn.demo.random.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.demo.random.interceptor.LogbackInterceptor;

@Configuration
public class MvcConfiguration {
	
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
				System.out.println("************************************Adding interceptors******************************************");
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
	
}
