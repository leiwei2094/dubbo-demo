package com.leolei.dubbodemo.consumer.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.ServletContextListener;

@ComponentScan
@Configuration
@ImportResource(locations={"classpath:application-context.xml"})
public class ApplicationConfiguration {

    @Bean
    public ServletContextListener listener(){
        return new ContextDestroyListener();
    }

}
