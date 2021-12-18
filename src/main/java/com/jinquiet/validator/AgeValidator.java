package com.jinquiet.validator;

import com.jinquiet.exception.EmailValidationException;
import com.jinquiet.exception.ValidationException;

public class AgeValidator implements Validator<String> {

    private static final Integer LOWER_LIMIT = 0;
    private static final Integer UPPER_LIMIT = 0;

    public boolean validate(String str) throws EmailValidationException {
        Boolean result = false;

        IntegerValidator iv = new IntegerValidator();

        //ValidationChain vc.validate((str)->iv).validate(() -> ())

        try {
            if (iv.validate(str))

            Integer.parseInt(str);
            result = true;
        } catch (NumberFormatException e) {
            throw new ValidationException(e);
        }

        return result;
    }
}