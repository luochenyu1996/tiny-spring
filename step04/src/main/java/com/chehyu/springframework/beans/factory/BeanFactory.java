package com.chehyu.springframework.beans.factory;

import com.chehyu.springframework.beans.BeansException;

/**
 * 工厂接口
 *
 * @author chen yu
 * @create 2022/1/22
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object... args) throws BeansException;
}
