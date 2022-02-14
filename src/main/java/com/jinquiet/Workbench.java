package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Workbench
 *
 * Code made from the lecture
 * Евгений Борисов — Spring-потрошитель, часть 1
 *  * Jul 3, 2014
 *
 * https://www.youtube.com/watch?v=BmBr5diz8WA
 *
 */
public class Workbench {

    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();

        //context.getBean(Quoter.class).sayQuote();

        /*
        while (true) {
            Thread.sleep(1000);
            context.getBean(Quoter.class).sayQuote();
        }*/
    }
}