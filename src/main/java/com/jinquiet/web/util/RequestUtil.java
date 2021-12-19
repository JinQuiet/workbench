package com.jinquiet.web.util;

import java.util.Map;

public class RequestUtil {

    //check if path even exists
    public static boolean pathPresent(String path) {
        boolean result = false;

        if ((path != null) && (path.length()>1)) {
            result = true;
        }

        return result;
    }

    public static String cleanEndpointPath(String path) {
        return path.trim();
    }

    public static String trimTrailingSlash(String path) {
        
        path = cleanEndpointPath(path);

        return path.replaceAll("/*$", "");
    }

    public static String trimLeadingSlash(String path) {
        
        path = cleanEndpointPath(path);

        return path.replaceAll("^/*", "");
    }

    //this method gives you clean path comming from the client
    public static String getCleanPath(String path) {
    
        return trimTrailingSlash(cleanEndpointPath(path));
    }

    public static String patternToRegex(Map<String, String> pathParameterToRegexMapping, String path) {
        String regexPathPattern = path;

        for (Map.Entry<String, String> pathParameterPattern : pathParameterToRegexMapping.entrySet()) {
            regexPathPattern.replaceAll(pathParameterPattern.getKey(), pathParameterPattern.getValue());
        }

        //place markers for the beginning and the end of the string
        path = PathPattern.STR_START.concat(path);
        path = path.concat(PathPattern.STR_END);

        return regexPathPattern;
    }        
    
    //this method returns true if path matches regex pattern
    public static boolean regexMatchesPath(String regexPattern, String path) {

        return path.matches(regexPattern);

    }

}
