package com.chenyu.springframework.aop;

/**
 * 对JoinPoint所处的对象进行Class级别匹配
 *
 *
 *
 * @author chen yu
 * @create 2022-01-31 22:16
 */
public interface ClassFilter {


     /**
      *  当织入目标对象的class 与Pointcut所规定的类型相符合时候返回 true,否则返回false
      *  返回false 意味着不会进行织入
      *
      */
     boolean matches(Class<?> clazz);
}
