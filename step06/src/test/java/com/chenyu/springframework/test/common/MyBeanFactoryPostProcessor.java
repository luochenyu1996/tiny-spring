package com.chenyu.springframework.test.common;


import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.PropertyValue;
import com.chenyu.springframework.beans.PropertyValues;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
