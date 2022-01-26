package com.chenyu.springframework;

/**
 * BeanDefinition ：用于定义bean实例化信息，现在的实现是以一个 Object 存放对象。
 * @author chen yu
 * @create 2022/1/21
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean){
        this.bean=bean;
    }

    public Object getBean() {
        return bean;
    }
}
