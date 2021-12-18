package com.jinquiet.validator.impl;

import com.jinquiet.validator.ValidationResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NameValidatorTest {

    StringBuilder wrongName;

    @Before
    public void setUp() throws Exception {
        wrongName = new StringBuilder();
        wrongName.append("i".repeat(256));
    }

    @Test
    public void validateGetValidResult() {
        boolean expected = ValidationResult.valid().isValid();
        boolean actual = new NameValidator().validate("Spike").isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateGetInvalidResult() {
        boolean expected = ValidationResult.invalid("too long name").isValid();


        boolean actual = new NameValidator().validate(wrongName.toString()).isValid();
        assertEquals(expected,actual);
    }

    @Test
    public void validateEmptyName() {
        boolean expected = ValidationResult.invalid("too small name").isValid();


        boolean actual = new NameValidator().validate("").isValid();
        assertEquals(expected,actual);
    }
}