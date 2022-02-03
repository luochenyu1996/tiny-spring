package com.chenyu.springframework.aop;

/**
 *  切入点
 *  Pointcut:和joinPoint产生关联的规定的地方法
 *
 *  怎么理解这个规则？
 *  ----> 里面定义好了方法 获取 类过滤器 和方法过滤器 这连个就是规则
 *
 *
 *
 *
 * @author chen yu
 * @create 2022-01-31 22:18
 */
public interface Pointcut {

    /**
     * 匹配将执行织入操作的对象
     *
     */
    ClassFilter getClassFilter();

    /**
     * 匹配将执行织入操作的方法
     *
     */
    MethodMatcher getMethodMatcher();


}
