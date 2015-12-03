package cn.demo.random;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {
    
    public static void main(String[] args) throws Exception {
    	if(args != null){
    		for(String arg : args){
    			System.out.println(arg);
    		}
    	}
        SpringApplication.run(Application.class, args);
    }
}