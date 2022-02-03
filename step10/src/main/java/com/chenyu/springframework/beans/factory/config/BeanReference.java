package com.chenyu.springframework.beans.factory.config;

/**
 * Bean的引用
 *
 * @author chen yu
 * @create 2022-01-29 19:47
 */
public class BeanReference {

    private  final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
