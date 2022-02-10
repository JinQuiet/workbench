package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Workbench
 *
 * Code was taken from here
 *
 * Hooking Into the Spring Bean Lifecycle
 *
 * Yavuz Tas
 * August 11, 2020
 *
 * https://reflectoring.io/spring-bean-lifecycle/
 */
public class Workbench {

    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");

        ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("context.xml");
        String s = context.getBean(MySpringBean.class).getMessage();

        System.out.println("MySpringBean's toString ::" + s);

        context.close();
    }
}