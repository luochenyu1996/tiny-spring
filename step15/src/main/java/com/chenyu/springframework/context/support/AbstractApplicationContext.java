package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.context.ApplicationEvent;
import com.chenyu.springframework.context.ApplicationListener;
import com.chenyu.springframework.context.ConfigurableApplicationContext;
import com.chenyu.springframework.context.event.ApplicationEventMulticaster;
import com.chenyu.springframework.context.event.ContextClosedEvent;
import com.chenyu.springframework.context.event.ContextRefreshedEvent;
import com.chenyu.springframework.context.event.SimpleApplicationEventMulticaster;
import com.chenyu.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * 接口的抽象实现
 *
 * @author chen yu
 * @create 2022-01-29 20:13
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    /**
     * 事件广播器相关
     */

    private static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    /**
     * 实现接口 ConfigurableApplicationContext  中的方法
     */
    @Override
    public void refresh() throws BeansException {
        //1、创建BeanFactory ，并加载 BeanDefinition。
        //  refreshBeanFactory() 做的两件工作：创建 BeanFactory ,  把 BeanDefinition 加载进map
        refreshBeanFactory();

        //2、获取 BeanFactory 。由子类进行实现
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //3、添加  ApplicationContextAwareProcessor
        //
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        //4、在Bean实例化之前 执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //5、BeanPostProcessor需要提前与其他Bean 对象实例化之前进执行注册操作（这里只是对这个bean进行注册，而不是对其中的方法进行了调用）
        registerBeanPostProcessors(beanFactory);

        //6、初始化事件发布者（事件分发器）
        initApplicationEventMulticaster();

        //7、注册事件监听器  todo  这里拿不到自定义的监听器
        registerListeners();

        //8、提前实例化单例Bean对象

        beanFactory.preInstantiateSingletons();

        //9、发布容器刷新完成事件
        finishRefresh();


    }


    /**
     * 实现 ListableBeanFactory 中的方法
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * 实现 ListableBeanFactory 中的方法
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 实现 BeanFactory 中的方法
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    /**
     * 实现 BeanFactory 中的方法
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    /**
     * 实现 BeanFactory 中的方法
     */
    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return getBeanFactory().getBean(name, requireType);
    }


    /**
     * 实现 ConfigurableApplicationContext 中的方法
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }


    /**
     * 实现 ConfigurableApplicationContext 中的方法
     */
    @Override
    public void close() {
        //1、发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        //2、执行销毁单例bean的销毁方法
        getBeanFactory().destroySingletons();
    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 和方法  registerBeanPostProcessors() 进行区分
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        //按类型 从容器中取出 所有  BeanPostProcessor 对象
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        //加入到 beanPostProcessors 的Map 容器中
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }

    /**
     * 和方法invokeBeanFactoryPostProcessors() 进行区分
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster= new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }



    }


    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));

    }


}
