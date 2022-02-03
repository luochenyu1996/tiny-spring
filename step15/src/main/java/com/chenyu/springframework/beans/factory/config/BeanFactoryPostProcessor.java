package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.BeansException;

/**
 * 允许修改BeanDefinition属性信息
 *
 * @author chen yu
 * @create 2022-01-29 19:45
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有 BeanDefinition 加载完成后，实例化 Bean 对象之前， 提供修改BeanDefinition  属性的机制
     *
     * 这里的详细流程要参照的 refresh() 方法
     *
     *
     */

    void  postProcessBeanFactory(ConfigurableBeanFactory beanFactory) throws BeansException;




}
