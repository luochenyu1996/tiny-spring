package com.chehyu.springframework.beans.factory.support;

import com.chehyu.springframework.beans.BeansException;
import com.chehyu.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * bean实例化  方式  接口
 *
 * @author chen yu
 * @create 2022/1/25
 */
public interface InstantiationStrategy {
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor,Object[] args) throws BeansException;
}
