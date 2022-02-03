package com.chenyu.springframework.context.event;

import com.chenyu.springframework.context.ApplicationContext;
import com.chenyu.springframework.context.ApplicationEvent;

/**
 * 容器事件
 *
 * @author chen yu
 * @create 2022-01-29 20:09
 */
public class ApplicationContextEvent  extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }



    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
