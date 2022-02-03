package com.chenyu.springframework.beans.factory;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 比较重要的工厂接口
 *  1、提供操作 BeanDefinition 方法
 *  2、提供 对单例的 pre-instantiate  的方法
 *  3、提供 BeanPostProcessor 容器的操作方法
 *
 * @author chen yu
 * @create 2022-01-29 18:03
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);


}
