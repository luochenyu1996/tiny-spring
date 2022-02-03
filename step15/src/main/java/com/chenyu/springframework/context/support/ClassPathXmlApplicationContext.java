package com.chenyu.springframework.context.support;

import com.chenyu.springframework.beans.BeansException;

/**
 * 上下文的具体实现
 *
 * 1、 增加配置的路径属性、
 * 2、 在容器的创建过程中会刷新容器(这个也就是上下文的作用 )
 *
 * @author chen yu
 * @create 2022-01-29 20:16
 */
public class ClassPathXmlApplicationContext extends  AbstractXmlApplicationContext{
    /**
     * 创建工厂时候指定的路径
     *
     */
    private  String[]  configurations;

    public ClassPathXmlApplicationContext(String configurations) throws BeansException {
        this(new String[]{configurations});
    }


    /**
     * 该类创建的过程中就会执行上下文的刷新
     *
     */
    public ClassPathXmlApplicationContext(String[] configurations) throws  BeansException {
        this.configurations = configurations;
        refresh();
    }



    /**
     * 实现AbstractXmlApplicationContext中的抽象方法
     * 返回配置的路径
     *
     */
    @Override
    protected String[] getConfigLocations() {
        return configurations;
    }


}
