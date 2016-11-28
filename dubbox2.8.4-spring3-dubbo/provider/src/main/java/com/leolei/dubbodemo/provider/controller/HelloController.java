package com.leolei.dubbodemo.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello() throws InterruptedException {

        for (int i =0;i<5;i++){
            Thread.sleep(1000);
            logger.info("The " + i + " time thread sleep......");
        }

        return "hello";
    }
}
