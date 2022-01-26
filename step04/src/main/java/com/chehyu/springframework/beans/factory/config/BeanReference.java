package com.chehyu.springframework.beans.factory.config;

/**
 * bean 的引用
 *
 * @author chen yu
 * @create 2022/1/25
 */
public class BeanReference {
    private  final  String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
