package com.jinquiet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jinquiet.generic.AdvancedGenericDemo;
import com.jinquiet.generic.GenericDemo;
import com.jinquiet.generic.NonGenericArrayDemo;
import com.jinquiet.generic.OwnClassGenericDemo;
import com.jinquiet.generic.RawListDemo;
import com.jinquiet.generic.RecursiveGenericDemo;
import com.jinquiet.logger.LoggerWrapper;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("Generic Demo App Starts Now");
        logger.info("===========================");

        /*
            Uncomment the part you're interested in
                Sometimes you need to uncomment the part inside the provided class.
                Life is tough.
        */

        //new NonGenericArrayDemo().go();

        //new RawListDemo().go();

        //new GenericDemo().go();

        //new AdvancedGenericDemo().go();

        //new OwnClassGenericDemo().go();

        //new RecursiveGenericDemo().go();

    }
}

