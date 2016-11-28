package com.leolei.dubbodemo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.leolei.dubbodemo.api.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import static com.alibaba.dubbo.container.Main.SHUTDOWN_HOOK_KEY;

public class HelloService implements IHelloService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String sayHello(String name) {
        logger.info("Dubbo.shutdown.hook=" + System.getProperty(SHUTDOWN_HOOK_KEY));
        logger.info("Start to execute sayHello method......");
        for (int i =0;i<8;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("The " + i + " time thread sleep......");
        }
        logger.info("Complete execute sayHello method......");
        return "hello " + name;
    }

    @Override
    public String test(CommonsMultipartFile commonsMultipartFile) {
        return commonsMultipartFile.getName();
    }


}
