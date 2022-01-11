package com.jinquiet.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.jinquiet.logger.LoggerWrapper;

public class JavaRushStreamTutorial {
    private final static Logger logger = LoggerWrapper.getLogger(JavaRushStreamTutorial.class);
    
    public void go(){
        JavaRushExamples jre = new JavaRushExamples();
        
        /*
        //This is how you can create and initiate stream in Java
        jre.example01NaiveStream();
    
        //This is a demo of what you can do with IntStreams
        jre.example02HowStreamWorks();
*/
        //This is a demo of the ways of pbtaining a stream
        jre.example03HowToObtainAStream();
        
    }

    public void randomTryouts01(){
        
        int[] intArray = IntStream
                            .range(0, 10)
                            .toArray();
        
        Arrays.stream(intArray)
            .forEach(System.out::println);


        Supplier<Integer> supplier = new Supplier<Integer>() {
            private Integer value = 0;
            @Override
            public Integer get() {
                value = value + 3;

                return value;
            }
        };

        Integer[] integerArray;
        integerArray = Stream
                            .generate(supplier)
                            .limit(5)
                            .toArray(Integer[]::new);
        
        System.out.println();
        Arrays.stream(integerArray)
                .forEach(System.out::println);
    }            
}

class JavaRushExamples {
    private final static Logger logger = LoggerWrapper.getLogger(JavaRushExamples.class);    

    //This is how you can create and initiate stream in Java
    public void example01NaiveStream(){
        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        Stream stream = list.stream();
        logger.info(stream.toString());
    }

    //This is a demo of what you can do with IntStreams
    public void example02HowStreamWorks(){
        IntStream
                .of(50, 60, 70, 80, 90, 100, 110, 120)
                .filter(x -> x < 90)
                .map(x -> x + 10)
                .limit(3)
                .forEach(x -> System.out.print(x + ", "));
                System.out.println();                
    }

    //This is a demo of the ways of pbtaining a stream
    public void example03HowToObtainAStream(){

        Stream<?> streamDemo;

        //empty stream
        streamDemo = Stream.empty();
            logger.info(streamDemo.toString());
        
            
        List<String> streamList = Arrays.asList("qwe", "asd", "qwe", "rty", "qwe", "vbn", "qwe");
        
        //stream from the list   
        streamDemo = streamList.stream();
            streamDemo.forEach(System.out::println);
                System.out.println();

        Set<String> streamSet = new HashSet<>(streamList);
        //stream from the set        
        streamDemo = streamSet.stream();
             streamDemo.forEach(System.out::println);
                 System.out.println();             

    }    
}