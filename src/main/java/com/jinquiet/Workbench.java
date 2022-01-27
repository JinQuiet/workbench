package com.jinquiet;

import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jinquiet.game.RpsGameService;
import com.jinquiet.game.gamerules.Rps;
import com.jinquiet.game.model.RpsGameModel;
import com.jinquiet.logger.LoggerWrapper;
import com.jinquiet.stream.StreamTest;

/**
 * Workbench
 *
 */
public class Workbench {
    private final static Logger logger = LoggerWrapper.getLogger(Workbench.class);


    public static void main(String[] args) throws InterruptedException {
        logger.info("It's working");

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


    }

}
