package com.jinquiet.web.util;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jinquiet.web.mapping.RequestMapping;

public class WebUtils {

    private static final String REGEX_STR_START ="^";
    private static final String REGEX_STR_END ="$";

    //check if path even exists
    public static boolean pathPresent(String path) {
        boolean result = false;

        if ((path != null) && (path.length()>1)) {
            result = true;
        }

        return result;
    }

    public static String trimPath(String path) {
        return path.trim();
    }

    public static String trimTrailingSlashes(String path) {
        path = trimPath(path);

        return path.replaceAll("/*$", "");
    }

    public static String trimLeadingSlashes(String path) {
        path = trimPath(path);

        return path.replaceAll("^/*", "");
    }

    //this method gives you clean path after getting it from the client
    public static String getCleanPath(String path) {

        return trimTrailingSlashes(trimPath(path));
    }

    //transforms all occurences of %parameter% in the request mapping path to regex expressions
    public static String pathParamToRegex(Map<String, String> pathParameterToRegexMapping, String path) {

        String regexPathPattern = getCleanPath(path);

        for (Map.Entry<String, String> pathParameterPattern : pathParameterToRegexMapping.entrySet()) {
            regexPathPattern = regexPathPattern.replaceAll(pathParameterPattern.getKey(), pathParameterPattern.getValue());
        }

        return REGEX_STR_START + regexPathPattern + REGEX_STR_END;
    }

    //returns all request mappings for the provided request part
    public static List<RequestMapping> getMappingForRequestPart(List<RequestMapping> requestMapping, String path, Predicate<RequestMapping> requestPartCondition) {

        List<RequestMapping> mapingsForRequestPart = requestMapping.stream()
            .filter(requestPartCondition)
            .collect(Collectors.toList());

        return mapingsForRequestPart;
    }    

    //check if request part, pike request path or request method exists in the provided requestMapping
    public static boolean requestPartExists(List<RequestMapping> requestMapping, String path, Predicate<RequestMapping> requestPartCondition) {

        boolean pathExists = requestMapping.stream()
            .filter(requestPartCondition)
            .findAny()
            .isPresent();

        return pathExists;
    }

    public static String[] tokenizePath(String path) {

        path = trimLeadingSlashes(trimTrailingSlashes(path));
        
        String[] tokens = path.split("/+");

        return tokens;
    }
}