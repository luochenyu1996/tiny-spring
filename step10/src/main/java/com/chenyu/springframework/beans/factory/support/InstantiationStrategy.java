package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * bean实例化方式接口
 *
 * @author chen yu
 * @create 2022-01-29 19:57
 */
public interface InstantiationStrategy {

    Object instantiate (BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args);

}
