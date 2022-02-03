package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.core.io.DefaultResourceLoader;
import com.chenyu.springframework.core.io.ResourceLoader;

/**
 * 接口的抽象类
 *
 * @author chen yu
 * @create 2022-01-29 19:54
 */
public abstract class AbstractBeanDefinitionReader  implements BeanDefinitionReader{

    private BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry register) {
        this(register,new DefaultResourceLoader());

    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
