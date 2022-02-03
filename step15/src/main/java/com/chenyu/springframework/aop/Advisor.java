package com.chenyu.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * 管理advice
 *
 * @author chen yu
 * @create 2022-01-31 22:14
 */
public interface Advisor {
    Advice getAdvice();

}
