package com.chenyu.springframework.context.event;

import com.chenyu.springframework.beans.factory.BeanFactory;
import com.chenyu.springframework.context.ApplicationEvent;
import com.chenyu.springframework.context.ApplicationListener;

/**
 * 广播器的据淘宝实现
 *
 * @author chen yu
 * @create 2022-01-29 20:12
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {


    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
