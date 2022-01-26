package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.PropertyValues;

/**
 * bean定义
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class BeanDefinition {

   private Class beanClass;
   private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = (propertyValues!=null?propertyValues:new PropertyValues());
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
