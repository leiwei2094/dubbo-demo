package com.leolei.dubbodemo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.leolei.dubbodemo.api.IHelloService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class HelloService implements IHelloService{
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String test(CommonsMultipartFile commonsMultipartFile) {
        return commonsMultipartFile.getName();
    }


}
