package com.chenyu.springframework.aop.framework;

import com.chenyu.springframework.aop.AdvisedSupport;

/**
 * todo
 *
 * 给容器封装 aop
 *
 * @author chen yu
 * @create 2022-01-31 22:24
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object  getProxy(){
        return  createAopProxy().getProxy();
    }

    private  AopProxy createAopProxy(){
        if(advisedSupport.isProxyTargetClass()){
            return  new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }

}
