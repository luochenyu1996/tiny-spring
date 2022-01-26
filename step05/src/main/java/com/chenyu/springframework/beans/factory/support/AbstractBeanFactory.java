package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.PropertyValues;
import com.chenyu.springframework.beans.factory.BeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象工厂
 *
 * 实现了 getBea()
 * 增加了两个抽象方法：getBeaDefinition() ;  creatBean()
 *
 * @author chen yu
 * @create 2022/1/26
 */
public abstract class AbstractBeanFactory  extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }


     protected <T> T  doGetBean(final String name,final Object[] args){
         Object bean = getSingleton(name);
         if(bean!=null){
             return  (T)bean;
         }
         BeanDefinition beanDefinition = getBeanDefinition(name);
         return  (T)creatBean(name,beanDefinition,args);
     }

     /**
      * 该类增加的方法
      *
      */
      protected abstract BeanDefinition getBeanDefinition(String beanName);

      protected abstract  Object creatBean(String beanName,BeanDefinition beanDefinition,Object[] args);
}
