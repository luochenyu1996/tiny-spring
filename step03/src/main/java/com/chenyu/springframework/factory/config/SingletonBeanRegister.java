package com.chenyu.springframework.factory.config;

/**
 * 类注册接口
 *
 * @author chen yu
 * @create 2022/1/21
 */
public interface SingletonBeanRegister {

    Object getSingleton(String beanName);

}
