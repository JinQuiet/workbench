package com.jinquiet;

import java.io.PrintStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinquiet.exception.IntegerValidationException;
import com.jinquiet.json.Payload;
import com.jinquiet.validator.ValidationChain;
import com.jinquiet.validator.ValidationResult;
import com.jinquiet.validator.Validator;
import com.jinquiet.validator.impl.AgeValidator;
import com.jinquiet.validator.impl.EmailValidator;
import com.jinquiet.validator.impl.IntegerValidator;
import com.jinquiet.validator.impl.NameValidator;
import com.jinquiet.web.mapping.RequestMapping;
import com.jinquiet.web.util.PathPattern;
import com.jinquiet.web.util.RequestUtil;

/**
 * Workbench
 *
 */
public class Workbench {
    public static void main(String[] args) throws InterruptedException, IntegerValidationException {
        PrintStream so = System.out;

        so.format("====================Workbench==============%n");

        so.format("====================Validator Test END==============%n");

        User user = new User();
            user.setUsername("Max");
            user.setEmail("234234 qweqwe.com");
            user.setUserAge("1000");

        Validator<String> iv = new IntegerValidator("user.id");
        Validator<String> nv = new NameValidator("user.userName");
        Validator<String> ev = new EmailValidator("user.email");
        Validator<String> av = new AgeValidator("user.userAge");

        //chain strarts.
        ValidationChain<String> vc = new ValidationChain<>();

        ValidationResult chainResolutionResult = vc.nextLink("00000", iv)
                .nextLink(user.getUsername(), nv)
                .nextLink(user.getUserAge(), av)
                .nextLink(user.getEmail(), ev)
                .resolve();

        so.println("chainResolution :: " + chainResolutionResult);

            Payload<User> p = new Payload<User>(user, vc.getErrorMessages());

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(p);
                so.println("ResultingJSONstring = " + json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        so.format("====================Validator Test END==============%n");

        so.format("====================Request Mapping Test==============%n");

        String reqGetPathInfo = "/users";
        String reqGetPathInfoSlash = "/users/";
        
        
        RequestMapping requestMapping = new RequestMapping();
        requestMapping.setActionName("users.getAll");
        requestMapping.setPath(reqGetPathInfo); //I clean path here automatically
        requestMapping.setPathRegex(reqGetPathInfo); //regex should generate automatically

        so.println(requestMapping);

        //take dirty path --- reqGetPathInfoSlash

        //Clean it
        so.println(reqGetPathInfoSlash);
        String cleanPath = RequestUtil.getCleanPath(reqGetPathInfoSlash);
        so.println(cleanPath);
        
        String regexPath = RequestUtil.patternToRegex(PathPattern.getPathParameterToRegexMapping(), cleanPath);
        

        //ValidationChain vcPath = new  ValidationChain<String>().nextLink(cleanPath, );

        //so.println(vcPath.resolve().getErrorMessage());
        so.format("====================Request Mapping Test END==============%n");

    }
}