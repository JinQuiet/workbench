package com.jinquiet.validator;

import com.jinquiet.exception.EmailValidationException;

public class EmailValidator implements Validator<String> {

    private static final 
        String EMAIL_REGEXP = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";

    public boolean validate(String str) throws EmailValidationException {
        Boolean result = false;

        if (str.matches(EMAIL_REGEXP))
            result = true;
        else
            throw new EmailValidationException();

        return result;
    }
}