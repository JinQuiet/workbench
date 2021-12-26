package com.jinquiet.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.LoggingMXBean;

import javax.management.openmbean.OpenDataException;

import com.jinquiet.animal.Animal;
import com.jinquiet.animal.Cat;
import com.jinquiet.animal.Dog;
import com.jinquiet.animal.SiameseCat;
import com.jinquiet.animal.Wolf;
import com.jinquiet.genericclass.OneAnimalShelter;
import com.jinquiet.logger.LoggerWrapper;

public class OwnClassGenericDemo {
    private final static Logger logger = LoggerWrapper.getLogger(OwnClassGenericDemo.class);    
 
    public void go () {
        logger.info("===============Own Class Generic Demo========");

        OneAnimalShelter<Wolf> oas = new OneAnimalShelter<>();
        oas.setAnimal(new Wolf());
        Animal s = oas.getAnimal();

        logger.info(s.toString());

    }
}

