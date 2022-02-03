package com.chenyu.springframework.context;

/**
 * 事件发布者顶级接口
 *
 * @author chen yu
 * @create 2022-01-29 17:23
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);


}
