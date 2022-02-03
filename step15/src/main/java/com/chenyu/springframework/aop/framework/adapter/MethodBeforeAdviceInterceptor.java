package com.chenyu.springframework.aop.framework.adapter;

import com.chenyu.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import java.lang.reflect.Method;

/**
 * MethodInterceptor 中的接口
 * MethodInterceptor 中提供Invoke接口
 * 理解 ： MethodInterceptor 中提供invoke()方法的声明，但是advice 接口中只是一个标志接口，其中什么都没有
 * 因此 advice 的具体实现要 MethodeInterceptor接口中的invoke()方法进行实现(类似JDK的InvocationHandler 接口)
 *
 * 因此MethodeInterceptor 的实现类要关联 Advice 的对象
 * @author chen yu
 * @create 2022-01-31 22:25
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
       this.advice.before(methodInvocation.getMethod(),methodInvocation.getArguments(),methodInvocation.getThis());
        return methodInvocation.proceed();
    }



    /**
     * getter
     *
     */
    public MethodBeforeAdvice getAdvice() {
        return advice;
    }


    /**
     * setter
     *
     */
    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }
}
