package com.chenyu.springframework.context;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.Aware;

/**
 * 容器上下文感知顶级接口
 *
 * @author chen yu
 * @create 2022-01-29 17:21
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
