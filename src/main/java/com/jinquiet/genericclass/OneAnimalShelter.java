package com.jinquiet.genericclass;

import com.jinquiet.animal.Dog;

//you can use only Dog's when you specify type parameter <Dog>
public class OneAnimalShelter <T extends Dog> {

    private T animal;

    public T getAnimal() {
        return this.animal;
    }
    
    public void setAnimal(T animal) {
        this.animal = animal;
    }   
    
    public static<T> T doNothing(T animal) {
        return animal;
    }
}