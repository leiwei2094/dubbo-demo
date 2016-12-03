package com.leolei.dubbodemo.consumer.controller;

import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ContextDestroyListener implements ServletContextListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("context initialized......");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("context is being destroyed......");

        final Set<Thread> threads = Thread.getAllStackTraces().keySet();
        for (Thread thread : threads) {
            if (needManualDestroy(thread)) {
                synchronized (this) {
                    try {
                        thread.stop();
                        logger.info(String.format("Destroy  %s successful", thread));
                    } catch (Exception e) {
                        logger.warn(String.format("Destroy %s error", thread), e);
                    }
                }
            }
        }

        logger.info("start to execute ProtocolConfig.destroyAll......");
        ProtocolConfig.destroyAll();
        logger.info("Complete execute ProtocolConfig.destroyAll......");
    }

    private boolean needManualDestroy(Thread thread){
        final String threadName = thread.getName();
        for (String manualDestroyThreadIdentifier : MANUAL_DESTROY_THREAD_IDENTIFIERS) {
            if (threadName.contains(manualDestroyThreadIdentifier)) {
                return true;
            }
        }
        return false;
    }

    public static final List<String> MANUAL_DESTROY_THREAD_IDENTIFIERS = Arrays.asList("Hashed wheel timer");
}
