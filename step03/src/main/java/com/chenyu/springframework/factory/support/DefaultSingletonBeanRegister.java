package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例注册类
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {
    // bean 的 map 容器定义在这里
    Map<String, Object> singletonObjets = new HashMap<>();

    /**
     * 实现 ：获取bean
     *
     */
    @Override
    public Object getSingleton(String beanName) {
        return  singletonObjets.get(beanName);
    }

    /**
     * 往 map 容器中添加bean
     *
     */
     protected  void  addSingleton(String beanName,Object singletonObject){
         singletonObjets.put(beanName,singletonObject);
     }
}
