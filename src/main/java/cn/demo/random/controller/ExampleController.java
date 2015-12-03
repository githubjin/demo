package cn.demo.random.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController{

    @RequestMapping("/home")
    public String home(){
        return "Hello World!";
    }
    
    @RequestMapping("/")
    public String random(){
        return Math.random() + " bled oh yes";
    }

}