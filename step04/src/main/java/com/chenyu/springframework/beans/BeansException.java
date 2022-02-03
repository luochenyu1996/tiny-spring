package com.chenyu.springframework.beans;

/**
 * 异常
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class BeansException extends RuntimeException {


    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
