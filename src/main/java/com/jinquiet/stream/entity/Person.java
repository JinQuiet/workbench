package com.jinquiet.stream.entity;

import java.util.Arrays;

/*
Entity for stream testing purposes
*/
public class Person {
    private String name;
    private Integer age;
    private String[] interests;

    public Person(String name, Integer age, String[] interests) {
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String[] getInterests() {
        return interests;
    }
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", interests=" + Arrays.toString(interests) + ", name=" + name + "]";
    } 
}