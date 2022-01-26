package com.chenyu.springframework.test;

import com.chenyu.springframework.factory.config.BeanDefinition;
import com.chenyu.springframework.factory.support.DefaultListableBeanFactory;
import com.chenyu.springframework.test.bean.UserDao;
import com.chenyu.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

/**
 * 测试类
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class ApiTest {

    @Test
    public  void test_BeanFactory(){
        //1.初始化工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2. userDao 注册
        beanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class));

        //获取
        UserService userService = (UserService) beanFactory.getBean("userService", "宸宇");
        userService.queryUserInfo();
    }



    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }







}
