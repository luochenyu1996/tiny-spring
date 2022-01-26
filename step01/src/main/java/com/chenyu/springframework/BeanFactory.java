package com.chenyu.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
 *
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class BeanFactory {
    private Map<String,BeanDefinition> beanDefinitionMap= new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

     public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
     }

}
