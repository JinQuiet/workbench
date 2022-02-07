package com.jinquiet;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jinquiet.game.RpsGameService;
import com.jinquiet.game.gamerules.Rps;
import com.jinquiet.game.model.RpsGameModel;
import com.jinquiet.logger.LoggerWrapper;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);


    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");
        //new StreamTest().go();

        /*
        public class RpsGameModel {
            private String playerAction;
            private String opponentAction;
            private String gameResult;
        */

        RpsGameService rgs = new RpsGameService();

        Stream<RpsGameModel> rpsStream = Stream.generate(() -> rgs.play(Rps.ROCK.name()));


        Map<String, List<RpsGameModel>> mss =
                rpsStream
                .limit(1000000)
                .collect(Collectors.groupingBy(RpsGameModel::getGameResult));
                //.forEach(System.out::println);

        mss.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + " :: "+ e.getValue().size()));


        //new Stream00Rps().workWithStreamRPS();
        //new Stream01().workWithStream();
        //new Stream02().workWithStream();

        //System.out.println(s);();
        //new Stream03().workWithStream();
/************************************/
/* Some additional Stream Training*/
/************************************/
        //basic dataset
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd", "dad", "ccc");

        //Collectors.toList()
        List<String> resultToList = givenList.stream().collect(Collectors.toList());
        resultToList.forEach(System.out::println);
        System.out.println();

        //Collectors.toUnmodifiableList()
        List<String> resultToUnmodifiableList = givenList.stream().collect(Collectors.toUnmodifiableList());
        resultToUnmodifiableList.forEach(System.out::println);
        System.out.println();

        //Collectors.toSet()
        Set<String> resultToSet = givenList.stream().collect(Collectors.toSet());
        resultToSet.forEach(System.out::println);
        System.out.println();

        //Collectors.toUnmodifiableSet()
        Set<String> resultToUnmodifiableSet = givenList.stream().collect(Collectors.toSet());
        resultToUnmodifiableSet.forEach(System.out::println);
        System.out.println();

        //Collectors.toCollection()
        List<String>  resultToCollection = givenList.stream().collect(Collectors.toCollection(LinkedList::new));
        resultToCollection.forEach(System.out::println);
        System.out.println();

        //Collectors.toMap()
        Map<String, Integer>  resultToMap = givenList.stream().collect(Collectors.toMap(Function.identity(), String::length, (k1, k2) -> k1));
        resultToMap.forEach((k,v) -> System.out.println(k + " :: " + v ));
        System.out.println();

        //Collectors.collectingAndThen()
        List<String> resultCollectingAndThen = givenList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        resultCollectingAndThen.forEach(System.out::println);
        System.out.println();

        //Collectors.joining()
        String resultJoining = givenList.stream()
                .collect(Collectors.joining());
        System.out.println(resultJoining);
        System.out.println();

        //Collectors.counting()
        Long resultCounting = givenList.stream()
                .collect(Collectors.counting());
        System.out.println(resultCounting);
        System.out.println();

        //Collectors.summarizingDouble/Long/Int()
        DoubleSummaryStatistics resultSummarizingDouble = givenList.stream()
                .collect(Collectors.summarizingDouble(String::length));
        System.out.println(resultSummarizingDouble);
        System.out.println();

        //Collectors.maxBy()/minBy()
        Optional<String> resultMaxByMinBy = givenList.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(resultMaxByMinBy);
        System.out.println();

        //3.12. Collectors.groupingBy()
        Map<Integer, Set<String>> resultGroupingBy = givenList.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.toSet())));
        System.out.println(resultGroupingBy);
        System.out.println();

        //Collectors.partitioningBy()
        Map<Boolean, List<String>> resultPartitioningBy = givenList.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 2));

        System.out.println(resultPartitioningBy);
        System.out.println();


        //groupingBy with only identity
        Map<String, List<String>> resultGroupingByOne = givenList
                .stream()
                .collect(Collectors.groupingBy(Function.identity()));

        System.out.println(resultGroupingByOne);
        System.out.println();

        //groupingBy with identity and collector
        Map<String, List<String>> resultGroupingByTwo = givenList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));

        System.out.println(resultGroupingByTwo);
        System.out.println();

        //groupingBy with identity, collector and supplier
        Map<String, Set<String>> resultGroupingByThree = givenList
                .stream()
                .collect(Collectors.groupingBy(
                            Function.identity(),
                            () -> new HashMap<String, Set<String>>(),
                            Collectors.mapping(Function.identity(), Collectors.toSet())));

        System.out.println(resultGroupingByThree);
        System.out.println();


        Stream<String> stringStream = Stream.of("a", "b", "c", "d", "e");
        String stringResult = stringStream.collect(Collectors.joining());
            System.out.println(stringResult);
        stringStream = Stream.of("a", "b", "c", "d", "e");
        stringResult = stringStream.collect(Collectors.joining("-"));
            System.out.println(stringResult);
        stringResult = Arrays.asList(stringResult.split("-")).stream().collect(Collectors.joining("#", "<", ">"));
            System.out.println(stringResult);
        System.out.println();



    }

}
