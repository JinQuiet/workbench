package com.jinquiet.window;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class WindowGenerator {

    public Window generateWindow() {
        return createNewWindow();
    }

    @Lookup
    protected Window createNewWindow() {
        return null;
    }
}
