package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chenyu.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 山下文扩展
 *
 * @author chen yu
 * @create 2022-01-27 00:05
 */
public  abstract class AbstractXmlApplicationContext  extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocation = getConfiguration();

        if(null!=configLocation){
            beanDefinitionReader.loadBeanDefinitions(configLocation);
        }
    }

    protected  abstract String[]  getConfiguration();
}
