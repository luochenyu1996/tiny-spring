package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chenyu.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 1、实现 AbstractRefreshableApplicationContext 中加载 BeanDefinition 的方法
 *    这个类表示从xml 中进行加载
 *
 * @author chen yu
 * @create 2022-01-29 20:15
 */
public abstract class AbstractXmlApplicationContext  extends AbstractRefreshableApplicationContext{

    /**
     * 在没有  Context 接口的情下使用工厂，需要手动 new BeanDefinitionReader 去加载资源
     *
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        String[] configLocations = getConfigLocations();
        if(null!=configLocations){
            beanDefinitionReader.loadBeanDefinition(configLocations);
        }
    }

    /**
     *  获取xml 配置文件的位置
     *
     */
    protected abstract  String[] getConfigLocations();


}
