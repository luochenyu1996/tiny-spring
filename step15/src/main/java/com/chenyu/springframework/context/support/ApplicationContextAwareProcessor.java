package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.context.ApplicationContext;
import com.chenyu.springframework.context.ApplicationContextAware;

/**
 *
 *
 * @author chen yu
 * @create 2022-01-29 20:17
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private  final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return  bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
