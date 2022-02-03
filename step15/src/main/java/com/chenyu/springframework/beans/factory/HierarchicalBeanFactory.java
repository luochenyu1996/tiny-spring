package com.chenyu.springframework.beans.factory;

/**
 *
 * 这个类在源码中的作用较简单 但是还没搞明白
 * 工厂分层的作用
 * 工厂扩展接口 ---  这里对这个类不做使用，只做了继承处理
 *
 * @author chen yu
 * @create 2022-01-29 19:21
 */
public interface HierarchicalBeanFactory extends BeanFactory {

    //源码中的两个方法

    // 方法1:直接返回了父工厂。

    // 方法2:判断了本地的工厂中是否包含了这个Bean,
}
