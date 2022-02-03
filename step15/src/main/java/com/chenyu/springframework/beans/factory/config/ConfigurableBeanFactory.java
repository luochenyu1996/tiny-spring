package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 为工厂提供一些用户配置
 *
 * 1、操作  BeanPostProcessor  容器
 * 2、 销毁单例对象（继承了 SingletonBeanRegister的原因）
 *
 * @author chen yu
 * @create 2022-01-29 19:49
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegister {
    String SCOPE_SINGLETON="singleton";

    String SCOPE_PROTOTYPE="prototype";




    /**
     * 销毁单例对象
     *
     * 其实现由子类（AbstractBeanFactory）的其他父类（DefaultSingletonRegister）进行实现
     */
    void  destroySingletons();


    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
