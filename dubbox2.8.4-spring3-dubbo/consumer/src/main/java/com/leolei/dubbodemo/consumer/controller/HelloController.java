package com.leolei.dubbodemo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.leolei.dubbodemo.api.IFileService;
import com.leolei.dubbodemo.api.IHelloService;
import com.leolei.dubbodemo.api.IUserService;
import com.leolei.dubbodemo.api.User;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

//    @Autowired
//    private IHelloService helloService;
//
//    @Autowired
//    private IUserService userService;

    @Autowired
    private IFileService fileService;


//    @RequestMapping(value = "/hello")
//    public ModelAndView hello(){
//
//        String name = helloService.sayHello("world");
//
//        Map<String,Object> data = new HashMap<>();
//        data.put("username",name);
//
//        return new ModelAndView("user",data);
//    }
//
//    @RequestMapping(value = "/user")
//    public ModelAndView user(){
//
//        User user = userService.getUser("admin");
//        String name = user.getName();
//        Map<String,Object> data = new HashMap<>();
//        data.put("username",name);
//        return new ModelAndView("user",data);
//    }

    @RequestMapping(value = "/test")
    public ModelAndView test() throws FileNotFoundException {

        InputStream stream = new FileInputStream("/users/leiwei/hello.txt");

        //org.springframework.web.multipart.commons.CommonsMultipartFile file = new CommonsMultipartFile();
        fileService.upload("1234.txt",stream);

        Map<String,Object> data = new HashMap<>();
        data.put("username","");

        return new ModelAndView("user",data);
    }

}
