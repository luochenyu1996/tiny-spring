package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * xml文件应用上下文
 *
 * @author chen yu
 * @create 2022-01-27 10:38
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {

    }

    public ClassPathXmlApplicationContext(String configLocations) {
       this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
       this.configLocations=configLocations;
       refresh();
    }


    @Override
    protected String[] getConfiguration() {
        return configLocations;
    }
}
