package com.jinquiet.screensaver;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Random;

@Component
//@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("periodical")
public class Colorer {
    private Color color;

    public Colorer() {
        Random random = new Random();
        this.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public Color getColor() {
        return color;
    }
}
