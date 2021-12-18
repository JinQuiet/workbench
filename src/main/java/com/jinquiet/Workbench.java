package com.jinquiet;

import java.io.PrintStream;
import java.util.Map;

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

/**
 * Workbench
 *
 */
public class Workbench {
    public static void main(String[] args) throws InterruptedException, IntegerValidationException {
        PrintStream so = System.out;

        so.format("====================Workbench==============%n");


        RequestMapping rm = new RequestMapping();

        User user = new User();
            user.setUsername("Max");
            user.setUserAge("1000");
            user.setEmail("234234 qweqwe.com");

        Validator<String> iv = new IntegerValidator("user.id");
        Validator<String> nv = new NameValidator("user.userName");
        Validator<String> ev = new EmailValidator("user.email");
        Validator<String> av = new AgeValidator("user.userAge");

        ValidationChain<String> vc = new ValidationChain<>();

        ValidationResult chainResolutionResult;

            chainResolutionResult = vc.nextLink("123", iv)
                                .nextLink(user.getUsername(), nv)
                                .nextLink(user.getUserAge(), av)
                                .nextLink(user.getEmail(), ev)
                                .resolve();

            so.println("chainResolution :: " + chainResolutionResult);

            Payload<User> p = new Payload<User>(user, vc.getErrorMessages());

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(p);
                System.out.println("ResultingJSONstring = " + json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        so.format("====================end==============%n");
    }
}