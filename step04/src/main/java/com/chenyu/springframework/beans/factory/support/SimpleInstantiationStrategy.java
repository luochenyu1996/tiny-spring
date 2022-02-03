package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * bean 具体实例化的方式  使用 jdk自带的代理
 *
 * @author chen yu
 * @create 2022/1/25
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException {
        Class beanClazz = beanDefinition.getBeanClazz();
        try {
            if(null!=beanClazz) {
                return beanClazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return beanClazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            throw  new BeansException("Failed to instantiate ["+ beanClazz.getName()+"]",e);
        }

    }
}
