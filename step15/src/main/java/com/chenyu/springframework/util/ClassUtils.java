package com.chenyu.springframework.util;


/**
 *  工具类
 * @author chen yu
 * @create 2022-01-29 20:38
 */
public class ClassUtils {
    /**
     * 获取ClassLoader
     * 如果获取不到则 使用本类的类加载器
     *
     */
    public static ClassLoader  getClassLoader(){
        ClassLoader cl=null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
         //
        }
        if(cl==null){
            cl = ClassUtils.class.getClassLoader();
        }
        return  cl;
    }

    /**
     * 判断该类 是否由cglib进行生成
     *
     */
    public static boolean isCglibProxyClass(Class<?> clazz){
        return  (clazz!=null&&isCglibProxyClassName(clazz.getName()));
    }

    /**
     * 根据名称判断是否由CGlib生成
     *
     */
    public static  boolean isCglibProxyClassName(String className){
        return (className!=null&&className.contains("$$"));
    }

}
