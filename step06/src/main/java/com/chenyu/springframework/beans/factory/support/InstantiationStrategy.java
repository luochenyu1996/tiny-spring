package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface InstantiationStrategy {
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor,Object[] args)  throws BeansException;
}
