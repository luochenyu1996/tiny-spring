package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认实现
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class DefaultSingletonBeanRegistry  implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjets = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {

        return singletonObjets.get(beanName);
    }

     protected  void addSingleton(String beanName,Object  singletonObject) {
        singletonObjets.put(beanName,singletonObject);
     }
}
