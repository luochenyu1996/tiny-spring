package com.chenyu.springframework;

/**
 * 异常类
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class BeanException  extends RuntimeException{

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
