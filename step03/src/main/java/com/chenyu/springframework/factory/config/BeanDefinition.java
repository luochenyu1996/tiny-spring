package com.chenyu.springframework.factory.config;

/**
 * bean定义类
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
