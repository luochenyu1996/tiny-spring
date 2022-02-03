package com.chenyu.springframework.context.event;

/**
 * 容器事件
 *
 * @author chen yu
 * @create 2022-01-29 20:12
 */
public class ContextRefreshedEvent   extends ApplicationContextEvent{
    public ContextRefreshedEvent(Object source) {
        super(source);
    }


}
