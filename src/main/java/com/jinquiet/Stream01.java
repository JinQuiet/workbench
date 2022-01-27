package com.jinquiet;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;

public class Stream01 {
    private final static Logger logger = LoggerWrapper.getLogger(Stream02.class);    

    public void workWithStream() {
        logger.info("It's working");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result = numbers
                .stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, Integer::sum);
               
        logger.info(String.valueOf(result));
    }
}
