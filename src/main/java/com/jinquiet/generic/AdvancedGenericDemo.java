package com.jinquiet.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jinquiet.animal.Animal;
import com.jinquiet.animal.Cat;
import com.jinquiet.animal.Dog;
import com.jinquiet.animal.Tiger;
import com.jinquiet.animal.SiameseCat;
import com.jinquiet.animal.Wolf;
import com.jinquiet.logger.LoggerWrapper;

public class AdvancedGenericDemo {
    private final static Logger logger = LoggerWrapper.getLogger(AdvancedGenericDemo.class);    
 
    public void go () {
        logger.info("===============Advanced Generic Demo========");

        //Here you need to uncomment "List<" lines one at a time to see 
        //what is available and what is not
        //when you are using wildcards in the variable definitions

        List<Cat> genericList = new ArrayList<Cat>();
        //List<?> genericList = new ArrayList<SiameseCat>();
        //List<? extends Cat> genericList = new ArrayList<SiameseCat>();
        //List<? super Cat> genericList = new ArrayList<Cat>();

        //you add (make thecollection CONSUME) new elements to the collection
        genericList.add(new Cat());
       
        //you read (PRODUCE) new elements from collection
        Cat cat = genericList.get(0);
        logger.info(cat.toString());

        logger.info(String.valueOf(genericList.size()));

    }
}


