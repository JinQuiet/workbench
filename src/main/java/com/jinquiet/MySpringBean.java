package com.jinquiet;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MySpringBean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("======= [01] === setBeanName executed =======");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("======= [02] === setApplicationContext executed =======");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("======= [04] === @PostConstruct executed =======");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("======= [05] === afterPropertiesSet executed =======");
    }

    public void initMethod() {
        System.out.println("======= [06] === initMethod executed =======");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("======= [08] === preDestroy executed =======");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("======= [09] === destroy executed =======");
    }

    public void destroyMethod() {
        System.out.println("======= [10] === destroyMethod executed =======");
    }
}
