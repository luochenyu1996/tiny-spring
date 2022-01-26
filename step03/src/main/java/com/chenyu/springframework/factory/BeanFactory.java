package com.chenyu.springframework.factory;

import com.chenyu.springframework.BeanException;

/**
 * bean 工厂
 *
 * @author chen yu
 * @create 2022/1/21
 */
public interface BeanFactory {
    Object getBean(String beanName)  throws BeanException;

    /**
     * 进行参数上的拓展
     *
     */

    Object getBean(String beanName,Object... args)  throws BeanException;

}
