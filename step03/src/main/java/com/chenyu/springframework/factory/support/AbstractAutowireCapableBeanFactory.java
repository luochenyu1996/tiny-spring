package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 抽象工厂
 * 使用了cglib 的创建方式
 * @author chen yu
 * @create 2022/1/22
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    //使用了cglib 的创建方式
    private InstantiationStrategy instantiationStrategy= new CglibSubclassingInstantiationStrategy();



   /**
    * 实现了创建bean
    *
    */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Object bean=null;
        try {
            bean=createBeanInstance(beanName,beanDefinition,args);
        } catch (Exception e) {
           throw  new BeanException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected  Object createBeanInstance(String beanName,BeanDefinition beanDefinition,Object[] args){
         Constructor constructorToUse=null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        //这里的构造函数
        for (Constructor ctor : declaredConstructors) {
            if(null!=args&&ctor.getParameterTypes().length==args.length){
                constructorToUse=ctor;
                break;
            }

        }
        return getInstantiationStrategy().instantiate(beanName,beanDefinition,constructorToUse,args);
    }


    /**
     *  get  set 方法
     */
    private  InstantiationStrategy getInstantiationStrategy(){
        return  instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy=instantiationStrategy;
    }


}
