package com.leolei.dubbodemo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.leolei.dubbodemo.api.IHelloService;
import com.leolei.dubbodemo.api.IUserService;
import com.leolei.dubbodemo.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Reference
    private IHelloService helloService;

    @Reference
    private IUserService userService;


    @RequestMapping(value = "/hello")
    public String hello(){
        return helloService.sayHello("admin");
    }

    @RequestMapping(value = "/user")
    public String user(){

        User user = userService.getUser("admin");
        String name = user.getName();
        return name;
    }

}
