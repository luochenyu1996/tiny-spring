package com.chenyu.springframework.beans.factory.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.DisposableBean;
import com.chenyu.springframework.beans.factory.config.SingletonBeanRegister;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean朱岑接口默认实现
 *
 * @author chen yu
 * @create 2022-01-29 20:02
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegister {

    protected static  final Object  NULL_OBJECT=new Object();

    /**
     * 单例对象存储用的容器
     */
    private  Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 非单例的Bean?
     */
    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }

    /**
     *
     * 指定了销毁方法的bean 会执行这个方法
     *
     */
    public void  destroySingletons(){
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length-1; i >=0 ; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);

            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on  bean with name '" + beanName + "' threw an exception",e);
            }
        }
    }


}
