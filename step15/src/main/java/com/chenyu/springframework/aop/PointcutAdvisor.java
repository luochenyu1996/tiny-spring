package com.chenyu.springframework.aop;

/**
 * 管理切点 和 增强
 *
 * @author chen yu
 * @create 2022-01-31 22:19
 */
public interface PointcutAdvisor extends  Advisor{


    Pointcut getPointcut();

}
