package com.jinquiet.generic;
import java.util.logging.Logger;
import com.jinquiet.logger.LoggerWrapper;

import com.jinquiet.animal.Animal;
import com.jinquiet.animal.Wolf;
import com.jinquiet.genericclass.OneAnimalShelter;

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

