package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;
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

        ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("context.xml");

        context.close();
    }
}