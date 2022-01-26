package com.chehyu.springframework.beans.factory.config;

import com.chehyu.springframework.beans.PropertyValues;

/**
 * bean 定义
 * 这里相对前面进行了扩充
 * @author chen yu
 * @create 2022/1/22
 */
public class BeanDefinition {
   private   Class beanClazz;
   private PropertyValues propertyValues ;

    public BeanDefinition(Class beanClazz) {

        this.beanClazz = beanClazz;
        // 没有的话 new 一个空的
        this.propertyValues=new PropertyValues();

    }

    public BeanDefinition(Class beanClazz, PropertyValues propertyValues) {
        this.beanClazz = beanClazz;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClazz() {
        return beanClazz;
    }

    public void setBeanClazz(Class beanClazz) {
        this.beanClazz = beanClazz;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
