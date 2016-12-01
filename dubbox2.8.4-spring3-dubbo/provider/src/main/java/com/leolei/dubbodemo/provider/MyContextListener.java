package com.leolei.dubbodemo.provider;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MyContextListener extends org.springframework.web.context.ContextLoaderListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // stop running threads
        //stopRunningThreads();

//        try {
//            Thread.sleep(10 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // execute dubbo shutdown hook first
        logger.info("start to execute ProtocolConfig.destroyAll......");
        ProtocolConfig.destroyAll();
        logger.info("Complete execute ProtocolConfig.destroyAll......");

        // destroy spring application context
        logger.info("start to execute super.contextDestroyed(event)......");
        super.contextDestroyed(event);
        logger.info("Complete execute super.contextDestroyed(event)......");
    }

    public MyContextListener(){}

    public MyContextListener(WebApplicationContext context) {super(context);}

//    public void stopRunningThreads() {
//        logger.info("start to stop running threads......");
//
//        final Set<Thread> threads = Thread.getAllStackTraces().keySet();
//        for (Thread thread : threads) {
//            if (needManualDestroy(thread)) {
//                synchronized (this) {
//                    try {
//                        thread.stop();
//                        logger.info(String.format("Destroy  %s successful", thread));
//                    } catch (Exception e) {
//                        logger.warn(String.format("Destroy %s error", thread), e);
//                    }
//                }
//            }
//        }
//        logger.info("complete stop running threads......");
//    }
//
//    private boolean needManualDestroy(Thread thread){
//        final String threadName = thread.getName();
//        for (String manualDestroyThreadIdentifier : MANUAL_DESTROY_THREAD_IDENTIFIERS) {
//            if (threadName.contains(manualDestroyThreadIdentifier)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static final List<String> MANUAL_DESTROY_THREAD_IDENTIFIERS = Arrays.asList("Hashed wheel timer");
}
