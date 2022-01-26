package com.chenyu.springframework.test;

import com.chenyu.springframework.factory.config.BeanDefinition;
import com.chenyu.springframework.factory.support.DefaultListableBeanFactory;
import com.chenyu.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试类
 *
 * @author chen yu
 * @create 2022/1/21
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){

        //1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //3.第一次获取  bean
       UserService userService = (UserService)beanFactory.getBean("userService");
       userService.queryUserInfo();

       //4. 第二次获取 单例的方式\
        UserService userServiceSingleton = (UserService)beanFactory.getBean("userService");
        userServiceSingleton.queryUserInfo();


    }
}
