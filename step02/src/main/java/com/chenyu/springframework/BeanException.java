package com.chenyu.springframework;

/**
 * bean异常
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class BeanException  extends RuntimeException {
    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
