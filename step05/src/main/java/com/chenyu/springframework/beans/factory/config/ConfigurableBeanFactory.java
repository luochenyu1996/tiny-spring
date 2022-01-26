package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author chen yu
 * @create 2022/1/26
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
