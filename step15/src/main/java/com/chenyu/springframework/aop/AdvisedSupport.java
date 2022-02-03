package com.chenyu.springframework.aop;


import org.aopalliance.intercept.MethodInterceptor;

/**
 * 对被代理对象进行封装
 *
 * @author chen yu
 * @create 2022-01-31 22:20
 */
public class AdvisedSupport {

    /**
     * 被代理的目标对象
     *
     */
    private TargetSource targetSource;


    /**
     * 方法拦截器(cglib)
     *
     */
    private MethodInterceptor methodInterceptor;

    /**
     * 方法匹配器(自定义)
     *
     */
    private  MethodMatcher methodMatcher;

    // ProxyConfig
    private boolean proxyTargetClass = false;

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }


    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }
}
