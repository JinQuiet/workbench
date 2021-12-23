package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;
import com.jinquiet.pattren.creational.FactoryMethod;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");

        FactoryMethod.go();
    }
}

