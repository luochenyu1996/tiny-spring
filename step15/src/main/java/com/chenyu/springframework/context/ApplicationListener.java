package com.chenyu.springframework.context;

/**
 * 事件监听者顶级接口
 * 由使用者进行实现
 * @author chen yu
 * @create 2022-01-29 17:24
 */
public interface ApplicationListener<E extends  ApplicationEvent> {


    void onApplicationEvent(E event);

}
