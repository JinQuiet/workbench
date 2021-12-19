package com.jinquiet.web.mapping;

import java.util.ArrayList;
import java.util.List;

import com.jinquiet.requestmapping.RequestMethod;

public class RequestMappingPool {

    private static List<RequestMapping> requestMapping = new ArrayList<RequestMapping>();

    static {
        //list AllUsers
        RequestMapping getUsers = new RequestMapping();
        getUsers.setActionName("getUsers");
        getUsers.setPath("/users");
        getUsers.setContentType("application/json");
        getUsers.setRequestMethod(RequestMethod.GET.name());
        getUsers.setPathParameters(new String[]{});        

        //get 1 (one) user data
        RequestMapping getUser = new RequestMapping();
        getUser.setActionName("getUser");
        getUser.setPath("/users/%integer%");
        getUser.setContentType("application/json");        
        getUser.setRequestMethod(RequestMethod.GET.name());
        getUser.setPathParameters(new String[]{"userId"});

        //get data to create a new user (stub with defauld values)
        RequestMapping newUser = new RequestMapping();
        newUser.setActionName("newUser");
        newUser.setPath("/users/newUser");
        newUser.setContentType("application/json");
        newUser.setRequestMethod(RequestMethod.GET.name());
        getUser.setPathParameters(new String[]{});        

        requestMapping.add(getUsers);
        requestMapping.add(getUser);
        requestMapping.add(newUser);
    }

    public static List<RequestMapping> getRequestMapping() {
        return requestMapping;
    }
}