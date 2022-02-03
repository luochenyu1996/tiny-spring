package com.chenyu.springframework.beans.factory;

import com.chenyu.springframework.beans.BeansException;

/**
 * 实现此接口的  bean 能够感知到其所属的BeanFactory
 *
 * @author chen yu
 * @create 2022-01-29 18:00
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
