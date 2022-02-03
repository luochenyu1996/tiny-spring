package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.FactoryBean;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.chenyu.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 接口抽象类
 *
 * 1、
 * 实现BeanFactory中的getBean()方法
 * 并且区分了 bean是否是 FactoryBean 从而去不容的map中进行获取
 *
 * 2、
 * 关联 BeanPostProcessor ，并提供存储 BeanPostProcessor 的map
 *
 *
 * @author chen yu
 * @create 2022-01-29 19:54
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader= ClassUtils.getClassLoader();

    /**
     * bean执行初始化方法前 、 执行初始化方法之后
     *
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();


    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    @Override
    public <T> Object getBean(String name, Class<T> requireType) throws BeansException {
        return (T)getBean(name);
    }


    /**
     * 通用获取 bean 类
     *
     */
    protected  <T> T doGetBean(final String name, final Object[] args ){
        Object sharedInstance = getSingleton(name);

        if(sharedInstance!=null){
            // 如果是FactoryBean  则需要调用FactoryBean# getObject();
            return (T) getObjectForBeanInstance(sharedInstance,name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = creatBean(name, beanDefinition,args);
        return (T) getObjectForBeanInstance(bean,name);
    }

    /**
     * 这里 beanInstance instanceof FactoryBean 的话 需要去factoryBeanObjectCache
     *
     */
    private Object getObjectForBeanInstance(Object beanInstance,String beanName){
        if(!(beanInstance instanceof FactoryBean)){
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if(object==null){
          FactoryBean<?>  factoryBean= (FactoryBean<?>)beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return  object;
    }

    /**
     * 对BeanPostProcessor map 容器的操作
     *
     */
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }



    /**
     * 属性的getter
     *
     */
    public  List<BeanPostProcessor> getBeanPostProcessors() {
        return  this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }




    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException;


}
