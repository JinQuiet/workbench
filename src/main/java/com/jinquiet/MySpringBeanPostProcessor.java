package com.jinquiet;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MySpringBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringBean) {
            System.out.println("------- [03] === postProcessBeforeInitialization executed -------");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringBean) {
            System.out.println("------- [07] === postProcessAfterInitialization executed -------");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
