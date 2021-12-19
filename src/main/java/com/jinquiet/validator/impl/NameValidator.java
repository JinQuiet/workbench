package com.jinquiet.validator.impl;

import com.jinquiet.validator.ValidationResult;
import com.jinquiet.validator.Validator;

public class NameValidator implements Validator<String>{
    
    private static final Integer MINIMUM_LENGHT = 1;
    private static final Integer MAXIMUM_LENGTH = 255;

    private String validationTarget;

    private ValidationResult validationResult;

    public NameValidator() {
        this.validationTarget = "Error";
    }

    public NameValidator(String validationTarget) {
        this.validationTarget = validationTarget;
    }    

    public ValidationResult validate(String str) {

        validationResult = ValidationResult.invalid("Wrong Name Format");

        if ((str != null) && (str.length() >= MINIMUM_LENGHT) && (str.length() <= MAXIMUM_LENGTH))
            validationResult = ValidationResult.valid();

        return validationResult;
    }

    public String getValidationTarget() {
        return validationTarget;
    }

    public void setValidationTarget(String validationTarget) {
        this.validationTarget = validationTarget;
    }

}
