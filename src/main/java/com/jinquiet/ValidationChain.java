package com.jinquiet;

import com.jinquiet.validator.Validator;

public class  ValidationChain<T> {

    private boolean validationResult = true;

    public ValidationChain<T> nextLink(Validator<T> v, T value) {

        if (!v.validate(value)) validationResult = false;
        return this;
    }

    public boolean resolve() {
        return validationResult;
    }

}
