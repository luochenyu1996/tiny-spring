package com.chenyu.springframework.context.event;

import com.chenyu.springframework.context.ApplicationEvent;
import com.chenyu.springframework.context.ApplicationListener;

/**
 * 事件广播器
 *
 * @author chen yu
 * @create 2022-01-29 20:06
 */
public interface ApplicationEventMulticaster {
    /**
     * 给事件分发器添加事件监听器
     *
     */
    void addApplicationListener(ApplicationListener<?> listener);


    /**
     * 从事件分发器中移除事件监听器
     *
     */
    void removeApplicationListener(ApplicationListener<?> listener);


    /**
     * 给监听器 广播事件
     *
     */
     void multicastEvent(ApplicationEvent event);





}
