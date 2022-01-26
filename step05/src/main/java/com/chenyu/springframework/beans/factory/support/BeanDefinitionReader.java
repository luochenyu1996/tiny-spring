package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.core.io.Resource;
import com.chenyu.springframework.core.io.ResourceLoader;

/**
 *  这步骤增加的接口
 *
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegister getRegister();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;





}
