package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.factory.config.BeanDefinition;

/**
 * 类信息 注册类
 *
 * @author chen yu
 * @create 2022/1/22
 */
public interface BeanDefinitionRegister {
    /**
     *  向容器中进行注册  bean的定义
     *
     */

    void  registerBeanDefinition(String beanName , BeanDefinition beanDefinition);
}
