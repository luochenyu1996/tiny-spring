package com.chenyu.springframework.beans.factory.config;

import com.chenyu.springframework.beans.PropertyValue;
import com.chenyu.springframework.beans.PropertyValues;

/**
 * Bean的定义（解析配置文件得到）
 *
 * @author chen yu
 * @create 2022-01-29 19:43
 */
public class BeanDefinition {

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private Class beanClass;

    /**
     * bean 对象的属集合
     */
    private PropertyValues propertyValues;


    /**
     * bean 指定的初始化方法
     */
    private String initMethodName;

    /**
     * bean 指定的销毁方法
     */
    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;

    /**
     * bean 默认单例模式
     */
    private boolean singleton = true;

    private boolean prototype = false;


    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }


    /**
     * 判断 当前bean的范围
     */
    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }

    /**
     * getter 方法
     */
    public Class getBeanClass() {
        return beanClass;

    }

    /**
     * setter  设置bean的范围
     */
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.singleton = SCOPE_PROTOTYPE.equals(scope);
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

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }


}
