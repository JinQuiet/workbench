package com.jinquiet.screensaver;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.jinquiet.screensaver")
public class Config {
/*
    @Bean
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope("periodical")
    public Color color (){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }*/
/*
    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame();
    }
*/
    @Bean
    public static CustomScopeRegistryScopeBeanFactoryPostProcessor customScopeRegistryScopeBeanFactoryPostProcessor() {
        return new CustomScopeRegistryScopeBeanFactoryPostProcessor();
    }

    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(50);
        }
    }
}
