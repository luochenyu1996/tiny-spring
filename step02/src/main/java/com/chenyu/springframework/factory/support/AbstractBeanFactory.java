package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.BeanFactory;
import com.chenyu.springframework.factory.config.BeanDefinition;

/**
 * 抽象工厂
 * 继承 DefaultSingletonBeanRegistry 使得该工厂有了注册的功能
 *
 * @author chen yu
 * @create 2022/1/21
 */
public  abstract class AbstractBeanFactory  extends  DefaultSingletonBeanRegistry implements BeanFactory {
   /**
    *  实现 bean 获取方法
    *
    */
    @Override
    public Object getBean(String name)  throws BeanException{
        Object bean=getSingleton(name);
        if(bean!=null){
            return  bean;
        }

        //容器中没拿到, 看看有没有定义  如果有定义的话  就从bean定义容器中拿到定义  然后创建这个bean  并且把bean加入容器
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return  creatBean(name,beanDefinition);
    }

    /**
     * 过去bean定义
     *
     */
    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    /**
     *  创建bean
     *
     */
    protected  abstract Object creatBean (String name,BeanDefinition beanDefinition) throws  BeanException;
}
