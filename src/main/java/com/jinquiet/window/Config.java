package com.jinquiet.window;

import com.jinquiet.screensaver.ColorFrame;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan("com.jinquiet.window")
public class Config {

    @Bean
    @Lazy
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Window window(){
        return new Window();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        WindowGenerator windowGenerator = context.getBean(WindowGenerator.class);

        Window windowOne = windowGenerator.generateWindow();
        Window windowTwo = windowGenerator.generateWindow();
        Window windowThree = windowGenerator.generateWindow();

        System.out.println(windowOne.hashCode());
        System.out.println(windowTwo.hashCode());
        System.out.println(windowThree.hashCode());

    }
}
