package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.factory.config.BeanDefinition;

/**
 * 向注册表中进行注册
 *
 * @author chen yu
 * @create 2022/1/25
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
