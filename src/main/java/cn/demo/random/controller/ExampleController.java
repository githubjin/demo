package cn.demo.random.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.demo.random.config.ConfigurationPropertiesDemo;

@ManagedResource(objectName="random:name=ExampleController")
@RestController
@RequestMapping("/api")
public class ExampleController{

	@Autowired
	private ApplicationArguments applicationArguments;
	
	@Autowired
	private ConfigurationPropertiesDemo demo;
	
	@Value(value = "${app.mail.server}")
	private String text;
	@Value("${random.value}--${random.int}--${random.long}--${random.int(10)}--${random.int[1024,65536]}")
	private String randoms;
	
    @RequestMapping("/")
    public String home(){
        return "---------" + text + "---------- demo.getServer():" + demo.getServer();
    }
    
    @CrossOrigin
    @RequestMapping("/{name}")
    public String random(@PathVariable String name){
        return "hello " + name;
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