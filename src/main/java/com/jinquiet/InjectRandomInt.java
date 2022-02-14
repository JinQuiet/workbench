package com.jinquiet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    public int min();
    public int max();
}
