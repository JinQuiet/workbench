package com.jinquiet;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.jinquiet.logger.LoggerWrapper;

public class Stream02 {
    private final static Logger logger = LoggerWrapper.getLogger(Stream01.class);

    public void workWithStream() {

        List<String> letters =
                Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        String s = letters.stream()
                .map(x -> x.toUpperCase() + ", " + x)
                //.reduce((x,y) -> x + y)
                .collect(Collectors.joining(", "));

        String ss = letters.stream()
                .map(e -> e.toUpperCase() + "," + e)
                .map(e -> e.split(","))
                .flatMap(Arrays::stream)
                .reduce((value, combinedValue) -> value + "," + combinedValue)
                .get();



        //A, a, B, b, C, c, D, d, E, e, F, f, G, g, H, h, I, i, J, j, K, k, L, l, M, m, N, n, O, o, P, p, Q, q, R, r, S, s, T, t, U, u, V, v, W, w, X, x, Y, y, Z, z

        logger.info(String.valueOf(s));
    }
}
