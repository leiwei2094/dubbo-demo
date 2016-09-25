package com.leolei.dubbodemo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.leolei.dubbodemo.api.IHelloService;
import com.leolei.dubbodemo.api.IUserService;
import com.leolei.dubbodemo.api.User;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/hello")
    public ModelAndView hello(){

        String name = helloService.sayHello("world");

        Map<String,Object> data = new HashMap<>();
        data.put("username",name);

        return new ModelAndView("user",data);
    }

    @RequestMapping(value = "/user")
    public ModelAndView user(){

        User user = userService.getUser("admin");
        String name = user.getName();
        Map<String,Object> data = new HashMap<>();
        data.put("username",name);
        return new ModelAndView("user",data);
    }

}
