package com.chenyu.springframework.beans.factory;

/**
 * 扩展接口
 *
 * 如果某个bean实现了该接口， 那么bean可以作为一个工厂，给容器中注入其他bean
 *
 * @author chen yu
 * @create 2022-01-29 18:06
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;


    Class<?> getObjectType();


    boolean isSingleton();
}
