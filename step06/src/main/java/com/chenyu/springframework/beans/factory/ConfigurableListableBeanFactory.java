package com.chenyu.springframework.beans.factory;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.AutowireCableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 工厂接口
 * 本步增加
 * @author chen yu
 * @create 2022/1/26
 */
public interface ConfigurableListableBeanFactory  extends ListableBeanFactory, AutowireCableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void  preInstantiateSingletons() throws  BeansException;

    void  addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
