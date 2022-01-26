package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.BeansException;

/**
 * 用于修改实例化bean 对象的扩展点
 *
 * @author chen yu
 * @create 2022-01-26 23:25
 */
public interface BeanPostProcessor {


    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法(区别初始化 和实例化)
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
