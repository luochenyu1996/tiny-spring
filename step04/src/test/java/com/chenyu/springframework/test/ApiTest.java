package com.chenyu.springframework.test;

import com.chehyu.springframework.beans.PropertyValue;
import com.chehyu.springframework.beans.PropertyValues;
import com.chehyu.springframework.beans.factory.config.BeanDefinition;
import com.chehyu.springframework.beans.factory.config.BeanReference;
import com.chehyu.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chenyu.springframework.test.bean.bean.UserDao;
import com.chenyu.springframework.test.bean.bean.UserService;
import org.junit.Test;

/**
 * 测试类
 *
 * @author chen yu
 * @create 2022/1/25
 */
public class ApiTest {
    @Test
    public void test(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // bean  注册
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        //设置属性

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
