package com.jinquiet.generic;

import java.net.PasswordAuthentication;
import java.util.logging.Logger;

import javax.sql.RowSetEvent;

import com.jinquiet.logger.LoggerWrapper;

public class RecursiveGenericDemo {
    private final static Logger logger = LoggerWrapper.getLogger(RecursiveGenericDemo.class);

    public void go() {
        logger.info("===============Recursive Generic Demo========");

    }
}

class Person {
    private String name;

    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", position=" + position + "]";
    }

}

interface BaseBuilder {

}

interface PersonInfoBuilder<T extends PersonInfoBuilder<T>> extends BaseBuilder{
    public T called(String name);
}

interface PersonJobBuilder <T extends PersonJobBuilder<T>> extends PersonInfoBuilder<PersonJobBuilder<T>>{
    public T worksAsA(String position);
}

interface PersonExpBuilder <T extends PersonExpBuilder<T>> 
    extends PersonJobBuilder<PersonExpBuilder<T>>{
    public T workExpIs(String experience);
}


class BuilderImpl <T> implements PersonExpBuilder<BuilderImpl<T>> {
    protected Person person = new Person();
    
    @Override
    public BuilderImpl <T> called(String name) {
        person.setName(name);
        return this;
    }

    @Override
    public BuilderImpl <T> worksAsA(String position) {
        person.setPosition(position);
        return this;
    }
    @Override
    public BuilderImpl <T> workExpIs(String experience) {
    
        return null;
    }

    public Person build(){
        return person;
    }    
}