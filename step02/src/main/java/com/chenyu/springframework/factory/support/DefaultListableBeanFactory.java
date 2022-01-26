package com.chenyu.springframework.factory.support;

import com.chenyu.springframework.BeanException;
import com.chenyu.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    //bean定义 容器
    private final Map<String,BeanDefinition> beanDefinitionMap=new HashMap<>();


    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition==null){
            throw new BeanException("No bean named '"+beanName+"' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);

    }
}
