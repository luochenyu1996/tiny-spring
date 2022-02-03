package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.factory.config.BeanDefinition;

/**
 * 这个类要区分BeanRegistry
 *
 * @author chen yu
 * @create 2022-01-29 19:55
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册列表进行注册  BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据名称从注册列表中获取 BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 根据名称判断注册列表中是否存在该  BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册列表中所有bean的名称
     */
    String[] getBeanDefinitionNames();


}
