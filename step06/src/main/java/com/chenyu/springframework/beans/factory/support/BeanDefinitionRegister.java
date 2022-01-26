package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;

/**
 * bean定义注册
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface BeanDefinitionRegister {
    /**
     * 向注册表中进行注册 beanDefinition
     *
     */
    void  registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 在注册表中进行查找
     *
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     *  查看是否包含
     *
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回容器中所有bean 的名称
     *
     */

    String[] getBeanDefinitionNames();



}
