package com.chenyu.springframework.beans;

/**
 * Bean异常
 *
 * @author chen yu
 * @create 2022-01-29 17:09
 */
public class BeansException  extends  RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
