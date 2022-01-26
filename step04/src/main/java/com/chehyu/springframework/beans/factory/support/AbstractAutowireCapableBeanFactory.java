package com.chehyu.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import cn.hutool.core.bean.BeanUtil;
import com.chehyu.springframework.beans.BeansException;
import com.chehyu.springframework.beans.PropertyValue;
import com.chehyu.springframework.beans.PropertyValues;
import com.chehyu.springframework.beans.factory.config.BeanDefinition;
import com.chehyu.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 抽象工厂
 * 这个类  主要的工作是 选择了使用cglib  的实例化方式
 * n
 * @author chen yu
 * @create 2022/1/22
 */
public abstract class AbstractAutowireCapableBeanFactory extends   AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy= new CglibSubclassingInstantiationStrategy();

    /**
     * 使用 cglib  去创建bean
     *
     */
    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object  bean= null;
        try {
            bean= creatBeanInstance(beanName,beanDefinition,args);
            //bean  创建完完成后进行属性的填充
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception e) {
           throw  new BeansException("Instantiation of bean failed",e);
        }
        //加入到容器
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object creatBeanInstance(String beanName,BeanDefinition beanDefinition, Object[] args){
        Constructor constructorToUse=null;
        Class<?> beanClazz = beanDefinition.getBeanClazz();
        //构造函数
        Constructor<?>[] declaredConstructors = beanClazz.getDeclaredConstructors();

        for (Constructor ctor : declaredConstructors) {
            // 使用哪个构造函数 这里是否能得改进 ？
            if(null!=args&&ctor.getParameterTypes().length==args.length){
                constructorToUse=ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName,beanDefinition,constructorToUse,args);
    }


    /**
     * bean 属性的填充
     *
     */
    protected  void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition){

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    //A  依赖B  , 获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value=getBean(beanReference.getBeanName());
                    System.out.println(value+"输出");
                }
                //进行属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (BeansException e) {
            throw  new BeansException("Error setting property values:"+beanName);
        }

    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
