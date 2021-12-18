package com.jinquiet.validator;

import com.jinquiet.exception.EmailValidationException;

public class EmailValidator implements Validator<String> {


    private final String validationTarget;

    private ValidationResult validationResult;

    public EmailValidator() {
        this.validationTarget = "Error";
    }

    public EmailValidator(String validationTarget) {
        this.validationTarget = validationTarget;
    }    

    private static final 
        String EMAIL_REGEXP = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";

    public ValidationResult validate(String str) throws EmailValidationException {

        validationResult = ValidationResult.invalid("Wrong Email Format");

        if (str.matches(EMAIL_REGEXP))
            validationResult = ValidationResult.valid();;

        return validationResult;
    }

    public String getValidationTarget() {
        return validationTarget;
    }    
}