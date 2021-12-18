package com.jinquiet.validator;

public interface Validator<T> {
    public boolean validate(T t);
}