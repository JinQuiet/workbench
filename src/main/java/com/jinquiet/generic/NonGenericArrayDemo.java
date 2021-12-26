package com.jinquiet.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.jinquiet.animal.Cat;
import com.jinquiet.animal.Dog;
import com.jinquiet.animal.Wolf;
import com.jinquiet.logger.LoggerWrapper;

public class NonGenericArrayDemo {
    private final static Logger logger = LoggerWrapper.getLogger(RawListDemo.class);        

    public void go() {

        logger.info("===============Non Generic Array Demo========");

        Dog[] arrayRaw = {
        //    new Object(),
        //    new Cat(),
            new Dog(),
        //    new SiameseCat(),
            new Wolf()
        };
        logger.info("**************** arrayRaw");
        Arrays.stream(arrayRaw).forEach((element) -> logger.info(element.toString()));
        
        //Runtime error we are adding wrong type of element into the Array!
        //Cat into Dog array
        
        //Object[] obj = arrayRaw;
        //obj[1] = new Cat();     
        
        
        List<Dog> listDog= new ArrayList<>();
            listDog.add(new Dog());
            listDog.add(new Wolf());
        List<Object> listObject = new ArrayList<>();
            //Compile Time error
            //listObject = listDog;
    }
}
