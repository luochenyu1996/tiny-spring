package com.chenyu.springframework.beans.factory;

import com.chenyu.springframework.beans.BeansException;

import java.util.Map;

/**
 * 工厂 扩展接口
 *
 * 声明其中两个抽象方法
 *
 * @author chen yu
 * @create 2022-01-29 19:23
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返bean实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册列表中所有Bean的名称
     */
    String[] getBeanDefinitionNames();


}
