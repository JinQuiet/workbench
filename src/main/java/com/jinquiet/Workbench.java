package com.jinquiet;

import java.io.PrintStream;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinquiet.exception.IntegerValidationException;

import com.jinquiet.validator.ValidationChain;
import com.jinquiet.validator.ValidationResult;
import com.jinquiet.validator.Validator;
import com.jinquiet.validator.impl.AgeValidator;
import com.jinquiet.validator.impl.EmailValidator;
import com.jinquiet.validator.impl.IntegerValidator;

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
            user.setUsername("some Name");
            user.setUserAge("1000");
            user.setEmail("@qweqwe.com");

        Validator<String> iv = new IntegerValidator("user.userId");
        Validator<String> ev = new EmailValidator("user.email");
        Validator<String> av = new AgeValidator("user.userAge");

        ValidationChain<String> vc = new ValidationChain<>();

        ValidationResult chainResolutionResult;

            chainResolutionResult = vc.nextLink("123", iv)
                                // .nextLink(user.getUsername(), av)
                                .nextLink(user.getUserAge(), av)
                                .nextLink(user.getEmail(), ev)
                                .resolve();


            so.println("chainResolution :: " + chainResolutionResult);




            Payload<User> p = new Payload<>();

            p.setPayload(user);
            p.setErrors(vc.getErrorMessages());

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

class Payload<T> {
    private T payload;
    private Map<String, String> errors;


    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }


}
