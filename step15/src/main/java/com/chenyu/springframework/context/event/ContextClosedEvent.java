package com.chenyu.springframework.context.event;

/**
 * 容器事件
 *
 * @author chen yu
 * @create 2022-01-29 20:11
 */
public class ContextClosedEvent extends  ApplicationContextEvent {
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
