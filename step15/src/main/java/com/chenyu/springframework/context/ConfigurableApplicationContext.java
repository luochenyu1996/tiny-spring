package com.chenyu.springframework.context;

import com.chenyu.springframework.beans.BeansException;

/**
 * 容器山下文接口 中的一个重要接口
 *
 * @author chen yu
 * @create 2022-01-29 17:25
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     */

    void  refresh() throws BeansException;


    /**
     * 向虚拟机注册钩子函数
     *
     */
    void registerShutdownHook();


    void close();
}
