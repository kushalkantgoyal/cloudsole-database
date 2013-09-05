package com.example.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.listener.Topic;

import com.example.model.Customer;
import com.example.service.CustomerService;

/**
 * @author Thys Michels
 */
public class Main {
    public static void main(String args[]) throws Throwable {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedisConfiguration.class);        
        applicationContext.registerShutdownHook();

        Topic topic = applicationContext.getBean(Topic.class);
        
        Log log = LogFactory.getLog(Main.class);
    }
}
