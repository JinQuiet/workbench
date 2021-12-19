package com.jinquiet.validator;

public interface Validator<T> {

    public ValidationResult validate(T t);

    public default String getValidationTarget() {
        return "error.general";
    }

}