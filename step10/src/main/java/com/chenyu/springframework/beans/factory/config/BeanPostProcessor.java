package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.BeansException;

/**
 * 修改实例化好的bean的扩展点
 *
 * @author chen yu
 * @create 2022-01-29 19:46
 */
public interface BeanPostProcessor {
    /**
     * Bean 初始化方法执行之前 执行该方法
     *
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;




    /**
     * Bean 初始化方法执行之后 执行该方法
     *
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
