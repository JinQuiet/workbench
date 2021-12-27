package com.jinquiet.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jinquiet.animal.Animal;
import com.jinquiet.animal.Cat;
import com.jinquiet.animal.Dog;
import com.jinquiet.animal.DomesticCat;
import com.jinquiet.animal.SiameseCat;
import com.jinquiet.animal.WildCat;
import com.jinquiet.animal.Wolf;
import com.jinquiet.logger.LoggerWrapper;

public class GenericDemo {
    private final static Logger logger = LoggerWrapper.getLogger(GenericDemo.class);    
 
    public void go () {
        logger.info("===============Basic Generic Demo========");

        logger.info("**************** listGeneric");
        List<Animal> listGeneric = new ArrayList<>();
        //listGeneric.add(new Object());
        listGeneric.add(new Animal());
        listGeneric.add(new Cat());
        listGeneric.add(new Dog());
        listGeneric.add(new SiameseCat());
        listGeneric.add(new Wolf());        

        listGeneric.forEach((e) -> logger.info(e.toString()));

        //PECS
        //Producer Extends   Consumer Super
        //get                add
        //extends            super
        //? extends Cat      ? super Cat        

        List<Cat> catList = new ArrayList<>();
            catList.add(new Cat());
            catList.add(new DomesticCat());
            catList.add(new SiameseCat());        

        produceAnimal(catList);
 
        List<Object> catObjectList = new ArrayList<>(); catObjectList.add(new Object());
        List<Animal> animalList = new ArrayList<>(); animalList.add(new Animal());
        List<DomesticCat> catDomesticList = new ArrayList<>(); catDomesticList.add(new DomesticCat());
        List<SiameseCat> catSiameseList = new ArrayList<>(); catSiameseList.add(new SiameseCat());        

        //Producer Extends
        //? extends Cat

        //produceAnimal(catObjectList);        
        //produceAnimal(animalList);        
        //here we've hit the BOUND (code above doesn't work)        
        produceAnimal(catList);        
        produceAnimal(catDomesticList);
        produceAnimal(catSiameseList);


        //Consumer Super
        //? super Cat   
        consumeAddAnimal(catObjectList);
        consumeAddAnimal(animalList);
        consumeAddAnimal(catList);
        //here we've hit the BOUND (code below doesn't work)
        //consumeAddAnimal(catDomesticList);
        //consumeAddAnimal(catSiameseList);
    }


    public List<? extends Cat> produceAnimal(List<? extends Cat> animals) {
        logger.info("**************** Producing all Animals");
        animals.forEach(e -> logger.info(e.toString()));

        Object object = animals.get(0); object.toString();

        Animal animal = animals.get(0); animal.toString();

        Cat cat = animals.get(0); cat.toString();

        //here we hit the BOUND (code below doesn't work)
        //DomesticCat domesticCat = animals.get(0);                        
        //SiameseCat s = animals.get(0);                                

        //We can NOT add new elements to this list
        //animals.add(new Object());

        return animals;
    }

    public List<? super Cat> consumeAddAnimal(List<? super Cat> animals) {
        logger.info("**************** Consuming new Animals");

        //animals.add(new Object()); //Doesn't work
        //animals.add(new Animal()); //Doesn't work
        //here we hit the BOUND (code above doesn't work)
        animals.add(new Cat());
        animals.add(new DomesticCat());
        animals.add(new WildCat());
        animals.add(new SiameseCat());

        animals.forEach(e -> logger.info(e.toString()));

        //We can NOT READ elements from this list into variables
        //DomesticCat domCat = animals.get(0);
        //Cat cat = animals.get(0);

        //It is possible to READ elements from this list into Object
        //Since this is the feature of Type Erasure
        //Object obj = animals.get(0);

        return animals;
    }    
}