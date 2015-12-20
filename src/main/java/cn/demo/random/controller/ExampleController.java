package cn.demo.random.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.demo.random.config.AppProperties;
import cn.demo.random.rbac.domain.RbacUser;

@ManagedResource(objectName="random:name=ExampleController")
@RestController
@RequestMapping("/api")
public class ExampleController{

	@Autowired
	private ApplicationArguments applicationArguments;
	
	@Autowired
	private AppProperties demo;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private MailProperties mailProperties;
	
	
	@Autowired
	private RedisProperties redisProperties;
	
	@Value("${random.value}--${random.int}--${random.long}--${random.int(10)}--${random.int[1024,65536]}")
	private String randoms;
	
    @RequestMapping
    public Object home(){
    	/*RedisClientInfo redisClientInfo = stringRedisTemplate.getClientList().get(0);
        return "---------" + text + "---------- demo.getServer():" + demo.getJwt().getHmacKey() 
        		+ " redis address port" + redisClientInfo.getAddressPort();*/
    	/*RbacUser rb = new RbacUser();
    	rb.setRealName("your name");
    	redisTemplate.opsForValue().set("users", rb);
    	Object object = redisTemplate.opsForValue().get("users");*/
    	return mailProperties;
    }
    
    @RequestMapping(value="arguments")
    public List<String> applicatinArguments(){
    	return this.applicationArguments.getNonOptionArgs();
    }
    
    @RequestMapping(value = "randoms")
    public String randomValues(){
    	return randoms;
    }
    
    @ManagedAttribute
    public String getName(){
    	return "123";
    }

}