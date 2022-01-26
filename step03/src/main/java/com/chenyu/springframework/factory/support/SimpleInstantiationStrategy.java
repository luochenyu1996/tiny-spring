package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 实例化接口实现
 *
 *
 * 这个类使用的是 jdk 本身的代理
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 实现实例化方法
     */
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
        //分为有构造函数和无构造函数
        try {
            if (null == ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException |NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            throw new BeanException("Filed to instance ["+clazz.getName()+"]",e);
        }

    }
}
