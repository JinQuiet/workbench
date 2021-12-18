package com.jinquiet.validator;

public class ValidationChain<T> {

        private boolean validationResult = true;


        public ValidationChain<T> nextLink(Validator<T> validator, T value) {

            if (!validator.validate(value)) validationResult = false;
            
            return this;
        }

        public boolean resolve() {
            return validationResult;
        }
}

