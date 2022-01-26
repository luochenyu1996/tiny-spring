package com.chenyu.springframework.beans.factory.config;

/**
 * 单例注册接口
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface SingletonBeanRegistry {
     Object getSingleton(String beanName);

}
