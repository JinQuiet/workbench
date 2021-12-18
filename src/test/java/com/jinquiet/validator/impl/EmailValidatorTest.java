package com.jinquiet.validator.impl;

import com.jinquiet.validator.ValidationResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void validateGetValidResult() {
        boolean expected = ValidationResult.valid().isValid();
        boolean actual = new EmailValidator().validate("example@gmail.com").isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateGetInvalidResult() {
        boolean expected = ValidationResult.invalid("Wrong email").isValid();
        boolean actual = new EmailValidator().validate("example.gmail.com").isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateEmptyString() {
        boolean expected = ValidationResult.invalid("Wrong email").isValid();
        boolean actual = new EmailValidator().validate("").isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateEmptyStringWithSpaces() {
        boolean expected = ValidationResult.invalid("Wrong email").isValid();
        boolean actual = new EmailValidator().validate("            ").isValid();
        assertEquals(expected,actual);
    }

}