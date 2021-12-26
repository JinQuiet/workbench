package com.jinquiet.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jinquiet.animal.Cat;
import com.jinquiet.animal.Dog;
import com.jinquiet.animal.SiameseCat;
import com.jinquiet.animal.Wolf;
import com.jinquiet.logger.LoggerWrapper;

public class RawListDemo {
    private final static Logger logger = LoggerWrapper.getLogger(NonGenericArrayDemo.class);        

    public void go() {

        logger.info("===============Raw List Demo========");
        
        /*
        List listRaw = new ArrayList();

        listRaw.add(new Object());
        listRaw.add(new Cat());
        listRaw.add(new Dog());
        listRaw.add(new SiameseCat());
        listRaw.add(new Wolf());
        
        listRaw.forEach((e) -> logger.info(e.toString()));
        */

        //It compiles normally! And we get class cast exception (Wolf is not a Cat!) 
        //Cat cat = (Cat)listRaw.get(4); 
    }

}
