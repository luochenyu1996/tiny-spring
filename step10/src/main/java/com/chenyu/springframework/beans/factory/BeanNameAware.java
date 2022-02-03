package com.chenyu.springframework.beans.factory;

/**
 * BeanName感知接口（子接口）
 *
 * 实现该接口的bean,可以感知到其在工厂中的beanName
 *
 * @author chen yu
 * @create 2022-01-29 17:56
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
