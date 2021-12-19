package com.jinquiet.validator.impl.web;

import java.util.List;

import com.jinquiet.validator.ValidationResult;
import com.jinquiet.validator.WebValidator;
import com.jinquiet.web.mapping.PathParamToRegexPool;
import com.jinquiet.web.mapping.RequestMapping;
import static com.jinquiet.web.util.WebUtils.*;

public class PathValidator implements WebValidator<String>{
    
    private String validationTarget;

    private List<RequestMapping> requestMapping = null;

    private ValidationResult validationResult;

    public PathValidator() {
        this.validationTarget = "web.error.path";
    }

    public PathValidator(String validationTarget, List<RequestMapping> requestMapping) {
        this.validationTarget = validationTarget;
        this.requestMapping = requestMapping;
    }    

    public ValidationResult validate(String path) {
        validationResult = ValidationResult.invalid("Wrong Entry Point Data :: " + path);

        if (requestPartExists(requestMapping, 
            path, 
            (mapping)->path.matches(pathParamToRegex(PathParamToRegexPool.getPathParamToRegexMapping(), mapping.getPath())))) 
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
