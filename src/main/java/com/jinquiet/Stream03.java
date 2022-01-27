package com.jinquiet;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.jinquiet.logger.LoggerWrapper;

public class Stream03 {
    private final static Logger logger = LoggerWrapper.getLogger(Stream01.class);

    public void workWithStream() {

        Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;

        Stream<UUID> infiniteStreamOfRandomUUID = Stream.generate(randomUUIDSupplier);

        /*
            8e3c01c2-c430-4f6e-9cc7-525a9e4e9e5d
            4a604e76-598f-426c-ae5d-fefc8a54a08a
            7ebf83e9-8bee-4d54-ab04-40a1b3ff1b49
            d422e0ed-d8e1-48b2-98d4-a280879dd871
            1412e39f-5f2b-4d6c-b027-2c923b941e27
            a0a8ebcd-6b79-4dfb-918c-6adcb07d57c2
            9b3ed6c5-300f-4ee1-989f-dd465f7b1beb
            9896b336-7294-4d7b-9a30-5cc73210f8eb
            f59a080e-e03c-42da-b12a-0c7fdbe4941e
            b739c4a9-99b5-47eb-8d04-c63226ba127f
        */

      
        //String s = "b739c4a9-99b5-47eb-8d04-c63226ba127f";

        /*
        из потока UUID извлечь вторые 10 элементов
            из этой строки
                b739c4a9-99b5-47eb-8d04-c63226ba127f
            отфильтровать
              99b5-47eb-8d04
            элементы
            выстроить все собнанные элементы в
                    7aea
                    4382
                    aa40
                    4128
            и вывести в толбик только цифры из этих строк, отфильтровав строки, которые = null
                    29
                    4269
                    3
                    754
                    441
                    9

         */

/*
        String so = "be4b";
        so = Arrays.stream(so.split("")).filter(e -> e.matches("[0-9]")).reduce(String::concat).get();


        System.out.println(so);
*/

        infiniteStreamOfRandomUUID
                .skip(10)
                .limit(10)
                .map(s -> Arrays.stream(s.toString().split("-")).skip(1).limit(3).collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .map(e -> Arrays.stream(e.split("")).filter(s -> s.matches("[0-9]")).reduce(String::concat).orElse(null))
                .peek(e -> System.out.println("Elem:: " + e))
                .filter(Objects::nonNull)

                /*

        c329
        4cf5

        3aae
        40cc
        9277
        */

                .forEach(System.out::println);

                /*
                    7aea
                    4382
                    aa40
                    4128
                    4baa
                    8e00
                    3287
                    4eb7
                    bd5c                
                */
    }
}
