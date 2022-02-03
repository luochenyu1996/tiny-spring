package com.chenyu.springframework.aop.framework;

/**
 * AOP代理的抽象
 *
 * @author chen yu
 * @create 2022-01-31 22:23
 */
public interface AopProxy {

    /**
     * 返回代理对象
     *
     */
    Object getProxy();


}
