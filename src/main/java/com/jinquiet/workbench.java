package com.jinquiet;

import java.io.PrintStream;

import com.jinquiet.exception.IntegerValidationException;
import com.jinquiet.validator.IntegerValidator;
import com.jinquiet.validator.ValidationChain;
import com.jinquiet.validator.Validator;

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

        Validator<String> iv = new IntegerValidator();
//         Validator<String> ev = new EmailValidator();

            so.println(iv.validate(""));


            /*
            String email = "123@mail.com";

            so.println(ev.validate(email));
            */

            ValidationChain<String> vc = new ValidationChain<>();

            Boolean chainResolution;
            chainResolution = vc.nextLink(iv, "-123").nextLink(iv, "1").resolve();

            so.println("chainResolution :: " + chainResolution);


        so.format("====================end==============%n");
    }
}