package com.chenyu.springframework.factory.config;

/**
 * bean 注册  接口
 * @author chen yu
 * @create 2022/1/21
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
