package com.leolei.dubbodemo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.leolei.dubbodemo.api.*;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFileService2 fileService2;

    @Autowired
    private ICarService carService;


    @RequestMapping(value = "/hello")
    public ModelAndView hello(){

        String name = helloService.sayHello("world");

        Map<String,Object> data = new HashMap<>();
        data.put("username",name);

        return new ModelAndView("user",data);
    }

    @RequestMapping(value = "/user")
    public ModelAndView user(){
        User user = new User("leiting");
        String name = userService.getName(user);
        Map<String,Object> data = new HashMap<>();
        data.put("username",name);
        return new ModelAndView("user",data);
    }

    @RequestMapping(value = "/test")
    public ModelAndView test() throws Exception {

        InputStream stream = new FileInputStream("/users/leiwei/baidu.png");

        //org.springframework.web.multipart.commons.CommonsMultipartFile file = new CommonsMultipartFile();
        //fileService.upload("1234.txt",stream);

        byte[] bytes = readInputStream(stream);
        fileService2.upload("1234.txt",bytes);

        Map<String,Object> data = new HashMap<>();
        data.put("username","");

        return new ModelAndView("user",data);
    }

    @RequestMapping(value = "/test2")
    public ModelAndView test2() throws Exception {

        String s = carService.start("bmw",new BMW());

        Map<String,Object> data = new HashMap<>();
        data.put("username",s);

        return new ModelAndView("user",data);
    }



    private static byte[] readInputStream(InputStream inputStream) throws Exception{
        byte[] buffer = new byte[1024];
        int len = -1;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        inputStream.close();
        return outputStream.toByteArray();
    }

}
