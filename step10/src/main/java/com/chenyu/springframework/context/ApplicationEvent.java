package com.chenyu.springframework.context;

import java.util.EventObject;

/**
 * 事件顶级抽象类（实现JDK的接口）
 *
 * @author chen yu
 * @create 2022-01-29 17:22
 */
public abstract  class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
