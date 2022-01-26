package com.chenyu.springframework.factory.config;

/**
 * 用于定义bean实例化信息--这里相对step01 进行了进化
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class BeanDefinition {

    private  Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
