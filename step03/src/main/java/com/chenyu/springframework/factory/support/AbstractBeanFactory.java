package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.BeanFactory;
import com.chenyu.springframework.factory.config.BeanDefinition;

/**
 * 抽象工厂
 *
 * @author chen yu
 * @create 2022/1/22
 */
public  abstract class AbstractBeanFactory  extends DefaultSingletonBeanRegister implements BeanFactory {
    /**
     * 获取bean
     *
     */
    @Override
    public Object getBean(String beanName) throws BeanException {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeanException {
        return doGetBean(beanName,args);
    }

    protected <T> T doGetBean(final String name,final Object[] args){
        Object bean = getSingleton(name);
        if(bean!=null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)  createBean(name,beanDefinition,args);


    }


    /**
     * 获取bean的定义
     *
     *
     */

    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException ;

    /**
     * 获取bean   这里是工厂模式的体现
     *
     */

    protected  abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException ;
}
