package com.jinquiet.validator.impl;

import com.jinquiet.validator.ValidationResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerValidatorTest {

    @Test
    public void validateGetValidResult() {
        boolean expected = ValidationResult.valid().isValid();
        boolean actual = new IntegerValidator().validate("1").isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateGetInvalidResult() {
        boolean expected = ValidationResult.invalid("Not integer").isValid();
        boolean actual = new IntegerValidator().validate("sss").isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateEmptyArgument() {
        boolean expected = ValidationResult.invalid("Not integer").isValid();
        boolean actual = new IntegerValidator().validate("").isValid();
        assertEquals(expected,actual);
    }
}