package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.context.ConfigurableApplicationContext;
import com.chenyu.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象上下文
 *
 * @author chen yu
 * @create 2022-01-26 23:08
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        //1. 创建beanFactory  并加载 BeanDefinition
        refreshBeanFactory();
        //2. 获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //3.在bean实例化之前  执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //4. BeanPostProcessor 需要提前宇其他bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //5 .提前实例化单例bean 对象
        beanFactory.preInstantiateSingletons();

    }

    /**
     * 新增加的两个重要方法
     *
     */
    protected  abstract void  refreshBeanFactory() throws  BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();


    private  void  invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

     private  void  registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
         Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);

         for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
             beanFactory.addBeanPostProcessor(beanPostProcessor);
         }

     }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name,requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
