package cn.demo.random;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cn.demo.random.config.AppProperties;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableConfigurationProperties({AppProperties.class, LiquibaseProperties.class})
public class Application {
    
    public static void main(String[] args) throws Exception {
    	if(args != null){
    		for(String arg : args){
    			System.out.println(arg);
    		}
    	}
        SpringApplication.run(Application.class, args);
//        WebAsyncManagerIntegrationFilter
//        SecurityContextPersistenceFilter
//        HeaderWriterFilter
//        LogoutFilter
//        JwtFilter
//        RequestCacheAwareFilter
//        SecurityContextHolderAwareRequestFilter
//        AnonymousAuthenticationFilter
//        SessionManagementFilter
//        ExceptionTranslationFilter
//        FilterSecurityInterceptor
    }
}