package com.leolei.dubbodemo.api;

import java.util.List;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface IHelloService {
    String sayHello(String name);

    String test(CommonsMultipartFile commonsMultipartFile);



}



