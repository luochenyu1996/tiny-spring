package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.BeanFactory;

/**
 * 工厂扩展接口
 * 自动装配相关：但是这里省略了其中的5种装配策论 导致 这列类名看的会不太合实际
 * @author chen yu
 * @create 2022-01-29 17:40
 */
public interface AutowireCapableBeanFactory  extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization()方法
     *
     */
     Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;



     /**
      * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization() 方法
      *
      *
      */

     Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;


}
