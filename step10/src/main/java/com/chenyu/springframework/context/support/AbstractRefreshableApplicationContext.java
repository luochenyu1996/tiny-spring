package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chenyu.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 1、实现 父类 AbstractApplicationContext  中的的两个抽象方法
 *    (1)  刷新工厂
 *          [1]创建工厂
 *          [2]加载BeanDefinition--有子类进行实现
 *    (2)  获取工厂
 *
 * @author chen yu
 * @create 2022-01-29 20:14
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

     private DefaultListableBeanFactory beanFactory;

     /**
      * 对AbstractApplicationContext 中的抽象方法进行了实现
      *
      */
    @Override
    protected void refreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = creatBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory=beanFactory;
    }

    /**
     * 区分  BeanDefinitionRegister 中的 loadBeanDefinitions
     *
     */
     protected  abstract  void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

     /**
      * 真正的工厂在这里才进行了创建
      *
      */
    private DefaultListableBeanFactory creatBeanFactory(){
        return new DefaultListableBeanFactory();

    }


    /**
     * 对AbstractApplicationContext 中的抽象方法进行了实现
     *
     */
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return  beanFactory;
    }
}
