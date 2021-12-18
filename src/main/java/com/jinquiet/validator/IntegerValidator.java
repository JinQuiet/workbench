package com.jinquiet.validator;

import com.jinquiet.exception.ValidationException;

public class IntegerValidator implements Validator<String>{

   public boolean validate(String str) throws ValidationException {
        Boolean result = false;

        try {
            Integer.parseInt(str);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }
}