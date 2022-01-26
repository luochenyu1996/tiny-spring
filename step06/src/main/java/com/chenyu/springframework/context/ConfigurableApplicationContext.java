package com.chenyu.springframework.context;

import com.chenyu.springframework.beans.BeansException;

/**
 * 接口扩展
 *
 * @author chen yu
 * @create 2022-01-26 23:06
 */
public interface ConfigurableApplicationContext extends  ApplicationContext{

    /**
     *  刷新容器
     *
     */

    void  refresh()  throws BeansException;
}
