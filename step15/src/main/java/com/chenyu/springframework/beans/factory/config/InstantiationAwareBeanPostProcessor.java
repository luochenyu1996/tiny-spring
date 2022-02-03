package com.chenyu.springframework.beans.factory.config;


import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.PropertyValues;

/**
 *
 * 这里只做了 AOP 相关
 *
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {




    /**
     * 与父接口中同名方法的区别是 这个方法用于提前(普通对象实例化之前)判断 是否需要使用AOP
     * 而父接口中的这个同名方法  是在普通对象 实例化完成后 执行init-method 方法用的
     *
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;


    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;


    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

}
