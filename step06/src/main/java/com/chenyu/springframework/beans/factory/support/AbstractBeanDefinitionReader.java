package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.core.io.DefaultResourceLoader;
import com.chenyu.springframework.core.io.ResourceLoader;

/**
 * 部分实现
 *
 *
 * @author chen yu
 * @create 2022/1/26
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private  final BeanDefinitionRegister register;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegister register) {
        this(register,new DefaultResourceLoader());

    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegister register, ResourceLoader resourceLoader) {
        this.register = register;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegister getRegister() {
        return register;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }


}
