package com.jinquiet.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

import com.jinquiet.logger.LoggerWrapper;

public class StreamTest {
    private final static Logger logger = LoggerWrapper.getLogger(StreamTest.class);
    public void go(){
        //empty Stream example
        Stream<?> streamEmpty = Stream.empty();
        logger.info(streamEmpty.toString());

        //collection Stream example
        Collection<String> collection = Arrays.asList("a", "b", "c", "d");
        Stream<String> streamOfCollection = collection.stream();
            logger.info(streamOfCollection.toString());
            streamOfCollection.forEach((val) -> System.out.print(String.valueOf(val) + ", "));
            System.out.println();

        //array Stream example
        //without making intermediary array
        Stream<String> streamOfArrayWithOf = Stream.of("q", "w", "e", "r", "t");
            logger.info(streamOfArrayWithOf.toString());
            streamOfArrayWithOf.forEach((val) -> System.out.print(String.valueOf(val) + ", "));
            System.out.println();

        //making intermediary array

        Integer[] integerArray = DataSource.getIntegerUnsortedArray();
        Stream<Integer> streamOfIntegers = Arrays.stream(integerArray);
            logger.info(streamOfIntegers.toString());
            streamOfIntegers.forEach((val) -> System.out.print(String.valueOf(val) + ", "));
            System.out.println();

        List<String[]> mapTest = DataSource.getPeopleList().stream().map(Person::getInterests).collect(Collectors.toList());

        mapTest.forEach((val) -> Arrays.stream(val).forEach(System.out::println));

        logger.info("====================================");

        List<Person> people = DataSource.getPeopleList();

        people
            .stream()
            .map((e) -> e.getInterests())
            .flatMap((val) -> Arrays.stream(val))
            .sorted(Comparator.reverseOrder())
            .distinct()
            .collect(Collectors.toList())
            .forEach((System.out::println));

            Comparator<String> cmp = Comparator.comparingInt(String::length)
            .thenComparing(String.CASE_INSENSITIVE_ORDER);

        //Find all people with the name Max and sort them by the number ot their interests
        //with interests sorted in the alphabetical order
        List<Person> peopleOne = 
            people
            .stream()
            .filter(e -> e.getName().equals("Max"))
            .sorted(Comparator.comparingInt(p -> p.getInterests().length))
            .collect(Collectors.toList());


        peopleOne
            .stream()
            .forEach(e -> Arrays.sort(e.getInterests()));
        
            peopleOne.stream().forEach(System.out::println);
    }
}


class Pair {
    private String one;
    private String two;

    public Pair(String one, String two) {
        this.one = one;
        this.two = two;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }
}

class DataSource {
    public static List<Person> getPeopleList() {
        Person person01 = new Person("Max", 30, new String[]{"Books", "Dogs"});
        Person person02 = new Person("Ted", 19, new String[]{"Music", "Cats", "Art"});
        Person person03 = new Person("Leo", 41, new String[]{"Cooking", "Electronics", "Knifes"});
        Person person04 = new Person("Max", 34, new String[]{"Books"});
        Person person05 = new Person("Don", 26, new String[]{"Books", "Gaming"});
        Person person06 = new Person("Max", 24, new String[]{"Manga", "Anime", "Gaming"});
        Person person07 = new Person("Tor", 29, new String[]{"Comix", "Manga", "Art"});

        List<Person> people = new ArrayList<>();
        people.add(person01);
        people.add(person02);
        people.add(person03);
        people.add(person04);
        people.add(person05);
        people.add(person06);
        people.add(person07);

        return people;
    }


    public static Integer[] getIntegerUnsortedArray() {
        return new Integer[]{5,3,24,543,7,4,35,92,46,57,69,18,54,2,7,8,3,12,765,2,45,23,3};
    }

    public static Integer[] getIntegerSortedArray() {
        return new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    }

}

class Person {
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

