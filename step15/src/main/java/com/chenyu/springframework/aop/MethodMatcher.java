package com.chenyu.springframework.aop;

import java.lang.reflect.Method;

/**
 * 方法级别的拦截
 *
 * @author chen yu
 * @create 2022-01-31 22:18
 */
public interface MethodMatcher {

    /**
     *  在源码中定义了两个重载的方法
     *
     */
    boolean matches(Method method ,Class<?> targetClass);

}
