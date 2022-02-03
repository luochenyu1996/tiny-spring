package com.chenyu.springframework.test;

import com.chenyu.springframework.test.event.CustomEvent;
import com.chenyu.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * 测试类
 *
 * @author chen yu
 * @create 2022-01-31 17:47
 */
public class ApiTest {



    /**
     * 测试 事件发布功能
     *
     */
    @Test
    public void  test_event(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));
        applicationContext.registerShutdownHook();
    }


}
