package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * cglib的方式进行创建对象
 * 这个类实现的是使用cglib
 * @author chen yu
 * @create 2022/1/22
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

   /**
    * 实现实例化方法
    *
    */
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        //如果你构造函数为空 则直接创建
        if (null==ctor){
            return enhancer.create();
        }
        //包含构造函数的创建
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
