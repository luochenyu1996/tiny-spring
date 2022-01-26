package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.config.BeanDefinition;

/**
 * 抽象工厂
 *
 * @author chen yu
 * @create 2022/1/21
 */
public   abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{
    //使用cglib处理含有构造函数的对象


    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean;

        try {
            //如果被创建的对象中含有构造函数 那么这里是存在坑的
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw  new BeanException("Instantiation of bean failed",e);
        }

        addSingleton(beanName,bean);
        return bean;
    }
}
