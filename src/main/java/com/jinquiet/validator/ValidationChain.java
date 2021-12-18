package com.jinquiet.validator;

import java.util.HashMap;
import java.util.Map;

public class ValidationChain<T> {

    private Map<String, String> errorMessages;
    private ValidationResult validationChainResult;

        public ValidationChain (){
            errorMessages = new HashMap<>();
        }

        public ValidationChain<T> getNewChain(){
            return new ValidationChain<T>();
        }

        public ValidationChain<T> nextLink(T value, Validator<T> validator) {
            validationChainResult = ValidationResult.valid();
            
            //invoke validator on the value (Integer Validator in the String value, etc)
            ValidationResult validationResult = validator.validate(value);
            if (validationResult.notValid()) {

                validationChainResult = 
                ValidationResult.invalid("An Error has occuredin the validation chain.");

                errorMessages.put(validator.getValidationTarget(), validationResult.getErrorMessage());
            }

            //return this validation chain back, to apply next value check
            return this;
        }

        public ValidationResult resolve() {
            return validationChainResult;
        }

        public boolean hasErrors() {
            return (errorMessages.size() == 0) ? false : true;
        }

        public Map<String, String> getErrorMessages() {
            return this.errorMessages;
        }
}