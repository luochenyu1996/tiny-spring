package com.chenyu.springframework.context.annotation;


import java.lang.annotation.*;

/**
 * bean 作用范围注解
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default  "singleton";
}
