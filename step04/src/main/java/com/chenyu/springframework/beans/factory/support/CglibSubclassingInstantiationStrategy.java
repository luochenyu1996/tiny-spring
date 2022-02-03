package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * cglib实例bean 的具体实现
 *  cglib  的用法
 * @author chen yu
 * @create 2022/1/25
 */
public  class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClazz());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        // 看是否有构造函数
        if(null==ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(),  args);
    }
}
