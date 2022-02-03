package com.chenyu.springframework.beans.factory;

/**
 * ClassLoader感知接口（子接口）
 *
 * 实现该接口，能感知到所使用的ClassLoader
 *
 * @author chen yu
 * @create 2022-01-29 17:54
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanBeanClassLoader(ClassLoader classLoader);


}
