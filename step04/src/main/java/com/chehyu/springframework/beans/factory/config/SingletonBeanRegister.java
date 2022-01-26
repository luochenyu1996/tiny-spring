package com.chehyu.springframework.beans.factory.config;

/**
 * 注册接口
 *
 * @author chen yu
 * @create 2022/1/22
 */
public interface SingletonBeanRegister {
    Object getSingleton(String  beanName);
}
