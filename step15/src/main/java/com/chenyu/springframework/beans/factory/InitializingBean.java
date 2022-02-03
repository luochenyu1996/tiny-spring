package com.chenyu.springframework.beans.factory;

/**
 * 初始化方法标志接口
 *
 *
 * @author chen yu
 * @create 2022-01-29 19:22
 */
public interface InitializingBean {
    /**
     * Bean 填充了属性后进行调用
     *
     */
    void afterPropertiesSet() throws  Exception;
}
