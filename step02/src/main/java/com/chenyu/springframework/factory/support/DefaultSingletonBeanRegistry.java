package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author chen yu
 * @create 2022/1/21
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
     //bean 对象容器
    Map<String ,Object> singletonObjects= new HashMap<String,Object>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected  void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }}
