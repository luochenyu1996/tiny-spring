package com.chenyu.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.PropertyValue;
import com.chenyu.springframework.beans.PropertyValues;
import com.chenyu.springframework.beans.factory.*;
import com.chenyu.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.config.BeanPostProcessor;
import com.chenyu.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 1、
 * 实现其父类(AbstractBeanFactory) 中的creatBean(如果容器中没有 getBean无法获取 则最终需要creatBean).
 * 其中 creatBean() 分为三个阶段:
 *   (1) 使用 实例化策略个根据 BeanDefinition进行实例化
 *   (2) Bean实例化完成后 进行属性的填充
 *   (3) 属性填充完成后  执行初始化方法
 *       初始化方法中有 :
 *          [1] 感知 Aware接口的判断
 *          [2] BeanPostProcessor 中的  before 和 after 方法的执行
 *
 *
 * 2、实现AutowireCapableBeanFactory接口中的前置和后置方法
 *
 *
 * 自动装配工厂接口的抽象类
 *
 * @author chen yu
 * @create 2022-01-29 19:51
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    /**
     * 实例化策略：使用CGlib的方式
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            //1.这里使用的是cglib实例化bean
            bean = creatBeanInstance(beanDefinition, beanName, args);
            //2.实例化完成后进行属性的填充
            applyPropertyValues(beanName, bean, beanDefinition);
            //3.执行bean的初始化方法
            // 于此同时执行BeanPostProcessor 的前置方法 和 后置方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of Bean failed", e);
        }
        return bean;
    }

    /**
     * bean 具体实例化方法
     */
    protected Object creatBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {

            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * bean 属性填充方法
     * todo
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                //bean 属性的 名称 和  值
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                // 看 当前的bean(A) 是否由 依赖其他的 bean(B)
                if (value instanceof BeanReference) {
                    //如果是依赖容器中的其他bean则根据引用 (BeanReference) 从容器中进行获取
                    BeanReference beanReference = (BeanReference) value;
                    //这里属性的值要从容器中进行获取
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }

        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }


    /**
     * bean 初始化方法
     */

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        //1.关联感知借口而 Aware
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                //把当前类设置进去
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware) {
                //把当前类设置进去
                ((BeanClassLoaderAware) bean).setBeanBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                //把当前类设置进去
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }

        //2.执行初始化前的方法 (BeanPostProcessor Before 方法 wrappedBean --> 被包裹的bean )
        Object wrappedBean= applyBeanPostProcessAfterInitialization(bean,beanName);
        try {
            invokeInitMethods(beanName,wrappedBean,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean [ "+beanName +"] failed",e);
        }


        //3.执行初始化后的方法（BeanPostProcessor  After 方法 ）
        wrappedBean= applyBeanPostProcessAfterInitialization(wrappedBean,beanName);
        return wrappedBean;
    }


    private void invokeInitMethods(String beanName,Object bean,BeanDefinition beanDefinition) throws Exception{
        //1.判断bean 是否实现接口 InitializingBean
        if(bean instanceof InitializingBean){
            ((InitializingBean)bean).afterPropertiesSet();
        }

        //2.执行注解配置的 init-method
        String initMethodName= beanDefinition.getInitMethodName();

        if(StrUtil.isNotEmpty(initMethodName)){
            //获取配置的 init-method
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if(null==initMethod){
                throw new BeansException("Could not find an  init method named ' "+initMethodName+"' on bean with  name '"+ beanName+"'");
            }
            initMethod.invoke(bean);


        }
    }


    /**
     * 实现 AutowireCapableBeanFactory 类中的方法
     *
     */
    @Override
    public Object applyBeanPostProcessBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result=existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()){
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if(null==current){
                return  result;
            }
            result =current;
        }
        return result;
    }

    /**
     * 实现 AutowireCapableBeanFactory 类中的方法
     *
     */
    @Override
    public Object applyBeanPostProcessAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result=existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()){
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if(null==current){
                return  result;
            }
            result =current;
        }
        return result;
    }


    /**
     * getter方法
     */
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    /**
     * getter方法
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
