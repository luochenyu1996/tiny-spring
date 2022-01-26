package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.BeanFactory;
import com.chenyu.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体工厂类
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister {

    //定义 的容器
    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 实现获取定义的方法
     *
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition==null){
            throw  new BeanException("No bean named ' "+beanName+"' is defined");
        }
        return  beanDefinition;
    }


    /**
     * 实现注册方法
     *
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
