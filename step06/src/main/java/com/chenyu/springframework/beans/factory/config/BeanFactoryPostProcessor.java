package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许修改 BeanDefinition 的属性信息
 *
 * @author chen yu
 * @create 2022-01-26 23:17
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition 加载完成后 ,实例化 Bean 对象之前  提供修改 BeanDefinition 属性的机制
     *
     *
     */

     void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;


}
