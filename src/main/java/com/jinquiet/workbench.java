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
        rm.setName("users");

        Validator<String> iv = new IntegerValidator("user.userId");
        Validator<String> ev = new EmailValidator("user.email");
        Validator<String> av = new AgeValidator("user.userAge");
            
            ValidationChain<String> vc = new ValidationChain<>();

            ValidationResult chainResolution;
            String integer = "2";
            String age = "fd";
            String email = "@dfg.com";

            chainResolution = vc.nextLink(integer, iv)
                                .nextLink(age, av)                             
                                .nextLink(email, ev)                                                             
                                .resolve();            
            /*
            chainResolution = vc.nextLink((a) -> (Integer.parseInt(s) > 0))
                                .nextLink(iv, "1")
                                .nextLink(av, "_")                                
                                .resolve();
            */

            so.println("chainResolution :: " + chainResolution);

            User user = new User();
            user.setUsername("some Name");
            user.setUserAge(12);
            user.setEmail("qweqwe@qweqwe.com");

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
