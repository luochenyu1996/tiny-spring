package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.factory.config.BeanDefinition;

/**
 * bean 定义 ---> bean 注册
 *  bean的注册接口
 *
 */
public interface BeanDefinitionRegistry {
   /**
    * 想注册表中注册 BeanDefinition
    *
    */
   void  registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
