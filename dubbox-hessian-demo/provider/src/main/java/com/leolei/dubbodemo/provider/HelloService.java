package com.leolei.dubbodemo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.leolei.dubbodemo.api.IHelloService;

public class HelloService implements IHelloService{
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
