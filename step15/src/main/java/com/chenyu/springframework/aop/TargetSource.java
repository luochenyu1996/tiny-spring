package com.chenyu.springframework.aop;

/**
 *
 * 对代理对象进行封装
 * @author chen yu
 * @create 2022-01-31 22:20
 */
public class TargetSource {

    private  final  Object target;

    public TargetSource(Object target) {
        this.target = target;
    }


    /**
     * 返回类实现的接口
     *
     */

    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }


    /**
     * getter方法
     *
     */
    public Object getTarget() {
        return target;
    }
}
