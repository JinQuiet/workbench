package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;
import com.jinquiet.stream.StreamTest;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");

        new StreamTest().go();

    }
}