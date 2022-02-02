package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Workbench
 *
 */
public class Workbench {

    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");

        ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("context.xml");
        String s = context.getBean(MySpringBean.class).getMessage();

        System.out.println(s);

        context.close();
    }
}