package com.chehyu.springframework.beans.factory.support;

import com.chehyu.springframework.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体实现
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegister {

   private Map<String, Object> singletonObjects = new HashMap<>();

   /**
    * 抽象方法实现
    *
    */
   @Override
    public Object getSingleton(String beanName) {

        return singletonObjects.get(beanName);
    }

    /**
     * 扩展方法
     *
     *
     */

     protected void  addSingleton(String beanName ,Object singletonObject){
         singletonObjects.put(beanName,singletonObject);
     }



}
