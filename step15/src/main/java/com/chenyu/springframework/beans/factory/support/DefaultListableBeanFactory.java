package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认工厂实现类
 * <p>
 * 1、
 * 实现BeanDefinitionRegister 接口；
 * 属性包含 BeanDefinition的map容器；
 * 实现gain借口的响应发方法
 * 2、
 *
 * @author chen yu
 * @create 2022-01-29 20:01
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {


    ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    /**
     * 实现 AbstractAutowireCapableBeanFactory  父接口   ListableBeanFactory 中的方法
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
//        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
//            Class beanClass = beanDefinition.getBeanClass();
//            if (type.isAssignableFrom(beanClass)) {
//                result.put(beanName, (T) getBean(beanName));
//            }
//        });

        for (String beanName : beanDefinitionMap.keySet()) {

            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            Class beanClass = beanDefinition.getBeanClass();

            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }

        }


        return result;
    }


    /**
     * 实现接口 BeanDefinitionRegister 的方法
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 实现接口 BeanDefinitionRegister 的方法
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    /**
     * 实现接口 BeanDefinitionRegister 的方法
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 实现接口 BeanDefinitionRegister 的方法
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    /**
     * 实现 ConfigurableListableBeanFactory 接口的方法
     */
    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }


}
