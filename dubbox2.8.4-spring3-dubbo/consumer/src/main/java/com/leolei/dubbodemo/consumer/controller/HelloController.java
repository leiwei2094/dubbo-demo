package com.leolei.dubbodemo.consumer.controller;

import com.leolei.dubbodemo.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello() throws InterruptedException {

        logger.info("start to execute HelloController.hello method......");
        logger.info("start to execute helloService.sayHello method......");
        String name = helloService.sayHello("world");
        logger.info("Complete execute helloService.sayHello method......the result is " + name);
        logger.info("Complete execute HelloController.hello method......");
        return name;
    }
}
