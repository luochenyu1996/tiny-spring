package com.chenyu.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.DisposableBean;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 *
 * @author chen yu
 * @create 2022-01-29 20:04
 */
public class DisposableBeanAdapter implements DisposableBean {

    private  final Object bean;
    private final  String beanName;
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        //这个方法的名字要从定义中取
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        /**
         * 1、实现接口的方式
         * 2、配置文件的方式
         */

        //1 、判断该bean 是否实现接口  DisposableBean
        if(bean instanceof  DisposableBean){
            //todo 这里再调用的时候会调用实现该接口bean的destroy方法
            ((DisposableBean)bean).destroy();
        }

        //destroy-method
        if(StrUtil.isNotEmpty(destroyMethodName)&&!(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))){
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null==destroyMethod){
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }

    }
}
