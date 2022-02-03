package com.chenyu.springframework.beans.factory;

import com.chenyu.springframework.beans.BeansException;

/**
 * 工厂的顶级接口
 *
 * 只声明 获取bean的方法 其他省略
 *
 * @author chen yu
 * @create 2022-01-29 17:43
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object... args) throws BeansException;

    <T>  Object getBean(String name,Class<T> requireType) throws BeansException;


}
