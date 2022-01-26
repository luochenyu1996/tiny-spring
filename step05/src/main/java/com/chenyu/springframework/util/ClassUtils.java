package com.chenyu.springframework.util;

/**
 * 工具类
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class ClassUtils {
    public  static ClassLoader getDefaultClassLoader(){
        ClassLoader cl=null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {

        }
        if(cl==null){
            //没有 classloader 的情况下 使用这个类的
            cl=ClassUtils.class.getClassLoader();
        }
        return  cl;
    }
}
