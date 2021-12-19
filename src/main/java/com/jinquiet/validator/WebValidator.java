package com.jinquiet.validator;

import java.util.List;

import com.jinquiet.web.mapping.RequestMapping;

public interface WebValidator<T> extends Validator<T>{

    public void setRequestMapping(List<RequestMapping> req);

}