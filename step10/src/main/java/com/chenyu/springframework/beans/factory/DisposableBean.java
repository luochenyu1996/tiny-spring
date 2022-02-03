package com.chenyu.springframework.beans.factory;

/**
 * 标记需要执行销毁方法的bean 使用的接口
 *
 * @author chen yu
 * @create 2022-01-29 18:05
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
