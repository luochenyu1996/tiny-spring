package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chenyu.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 实现 refresh() getBeanFactory() 方法
 *
 * @author chen yu
 * @create 2022-01-26 23:42
 */
public abstract class AbstractRefreshableApplicationContext extends  AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = creatBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory=beanFactory;
    }

    private  DefaultListableBeanFactory  creatBeanFactory(){
        return new DefaultListableBeanFactory();
    }

     protected  abstract  void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
