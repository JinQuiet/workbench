package com.jinquiet.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public class ColorFrame extends JFrame {
    /*    @Autowired
    private Color color;*/

/*    @Autowired
    private ApplicationContext applicationContext;*/

/*    @Autowired
    private Color color;*/

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
//        getContentPane().setBackground(color);
//        getContentPane().setBackground(applicationContext.getBean(Color.class));
//        getContentPane().setBackground(color);
        getContentPane().setBackground(getColor().getColor());
        repaint();
    }

    @Lookup
    protected Colorer getColor() {
        return null;
    }
}
