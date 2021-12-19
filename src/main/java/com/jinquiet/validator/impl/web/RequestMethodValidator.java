package com.jinquiet.validator.impl.web;

import java.util.List;

import com.jinquiet.validator.ValidationResult;
import com.jinquiet.validator.WebValidator;
import com.jinquiet.web.mapping.RequestMapping;
import static com.jinquiet.web.util.WebUtils.*;

public class RequestMethodValidator implements WebValidator<String>{
    
    private String validationTarget;

    private List<RequestMapping> requestMapping = null;

    private ValidationResult validationResult;

    public RequestMethodValidator() {
        this.validationTarget = "web.error.requestMethod";
    }

    public RequestMethodValidator(String validationTarget, List<RequestMapping> requestMapping) {
        this.validationTarget = validationTarget;
        this.requestMapping = requestMapping;
    }    

    public ValidationResult validate(String requestMethod) {
        validationResult = ValidationResult.invalid("Wrong Request Method :: " + requestMethod);

        if (requestPartExists(requestMapping, 
            requestMethod, 
            (mapping)->requestMethod.equals(mapping.getRequestMethod())))
            validationResult = ValidationResult.valid();            

        return validationResult;
    }

    public String getValidationTarget() {
        return validationTarget;
    }

    @Override
    public void setRequestMapping(List<RequestMapping> requestMapping) {
        this.requestMapping = requestMapping;
    }
}
