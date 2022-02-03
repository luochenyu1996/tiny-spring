package com.chenyu.springframework.aop.framework;

import com.chenyu.springframework.aop.AdvisedSupport;
import org.aopalliance.intercept.MethodInterceptor;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *   InvocationHandler JDK拦截器的接口
 *
 * @author chen yu
 * @create 2022-01-31 22:24
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    /**
     * 这个对象中含有被代理对象
     *
     */
    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }


    /**
     * 返回代理对象
     * Proxy.newProxyInstance(类加载器,目标对象class,Invocation)
     *
     */
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),advised.getTargetSource().getTargetClass(), this);

    }

    /**
     *  增强的内容
     *  包含处理增强的对象中的哪些方法
     *
     *  实现了接口的都会进行增强
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         *  matches() 进行匹配的方式：
         *  匹配规则在切点中进行了定义--切点中本身包含了表达式，
         *
         */
        if(advised.getMethodMatcher().matches(method,advised.getTargetSource().getTarget().getClass())){
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
        }
        return method.invoke(advised.getTargetSource().getTarget(),args);
    }
}
