package com.chenyu.springframework.beans.factory;

import com.chenyu.springframework.beans.BeansException;

import java.util.Map;

/**
 * 工厂接口
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     *  拓展上级接口
     *
     */
    <T> Map<String,T> getBeansOfType(Class<T>  type) throws BeansException;

    String[] getBeanDefinitionNames();








}
