package com.chenyu.springframework.aop;

import java.lang.reflect.Method;

/**
 * todo
 *
 * @author chen yu
 * @create 2022-01-31 22:18
 */
public interface MethodBeforeAdvice extends BeforeAdvice{


    void before(Method method, Object[] args, Object target) throws Throwable;


}
