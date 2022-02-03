package com.chenyu.springframework.beans.factory.config;

/**
 * 单例注册列表
 *
 * @author chen yu
 * @create 2022-01-29 19:50
 */
public interface SingletonBeanRegister {

    Object getSingleton(String BeanName);


    void  registerSingleton(String beanName,Object singletonObject);
}
