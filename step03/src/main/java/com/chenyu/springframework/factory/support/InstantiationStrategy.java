package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * bean实例化策略
 *
 * @author chen yu
 * @create 2022/1/22
 */
public interface InstantiationStrategy {
    Object instantiate (String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args);

}
