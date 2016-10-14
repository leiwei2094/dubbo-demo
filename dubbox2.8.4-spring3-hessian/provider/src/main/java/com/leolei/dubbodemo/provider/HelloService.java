package com.leolei.dubbodemo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.leolei.dubbodemo.api.IHelloService;
import com.leolei.dubbodemo.api.exception.MyApiException;
import com.leolei.dubbodemo.provider.exception.MyProviderException;

public class HelloService implements IHelloService{
    @Override
    public String sayHello(String name) {
        //throw new MyApiException("Hello World Exception","myId","myName");
        throw new  RuntimeException("Runtime Exception");
        //return "hello " + name;
    }
}
