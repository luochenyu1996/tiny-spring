package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.BeanFactory;

/**
 * 工厂接口
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现的 postProcessBeforeInitialization
     *
     *
     */


    Object  applyBeanPostProcessorsBeforeInitialization(Object existingBean,String beanName) throws BeansException;



    /**
     * 执行 BeanPostProcessors 接口实现的 postProcessAfterInitialization
     *
     *
     */

    Object  applyBeanPostProcessorsAfterInitialization(Object existingBean,String beanName) throws BeansException;



}
