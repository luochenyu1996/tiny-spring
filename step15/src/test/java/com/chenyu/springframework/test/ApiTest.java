package com.chenyu.springframework.test;

import com.chenyu.springframework.aop.AdvisedSupport;
import com.chenyu.springframework.aop.ClassFilter;
import com.chenyu.springframework.aop.MethodMatcher;
import com.chenyu.springframework.aop.TargetSource;
import com.chenyu.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.chenyu.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.chenyu.springframework.aop.framework.JdkDynamicAopProxy;
import com.chenyu.springframework.aop.framework.ProxyFactory;
import com.chenyu.springframework.aop.framework.ReflectiveMethodInvocation;
import com.chenyu.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import com.chenyu.springframework.context.support.ClassPathXmlApplicationContext;
import com.chenyu.springframework.test.bean.IUserService;
import com.chenyu.springframework.test.bean.UserService;
import com.chenyu.springframework.test.bean.UserServiceBeforeAdvice;
import com.chenyu.springframework.test.bean.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试类
 *
 * @author chen yu
 * @create 2022-02-01 16:59
 */
public class ApiTest {



    private AdvisedSupport advisedSupport;

    @Before
    public void init() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.chenyu.springframework.test.bean.IUserService.*(..))"));
    }

    @Test
    public void test_proxyFactory() {
        advisedSupport.setProxyTargetClass(false); // false/true，JDK动态代理、CGlib动态代理
        IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();

        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void test_beforeAdvice() {
        UserServiceBeforeAdvice beforeAdvice = new UserServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor interceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(interceptor);

        IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void test_advisor() {
        // 目标对象
        IUserService userService = new UserService();

        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* com.chenyu.springframework.test.bean.IUserService.*(..))");
        advisor.setAdvice(new MethodBeforeAdviceInterceptor(new UserServiceBeforeAdvice()));

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(userService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(userService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(true); // false/true，JDK动态代理、CGlib动态代理

            IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();
            System.out.println("测试结果：" + proxy.queryUserInfo());
        }
    }


    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new UserService();

        // AOP 代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);

    }


    /**
     * 测试动态代理
     *
     */
    @Test
    public  void  test_dynamic(){
        //1、目标对象
        IUserService userService = new UserService();

        //2、组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        //(2.1)包装目标对象
        advisedSupport.setTargetSource(new TargetSource(userService));
        //(2.2)配置增强内容
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        //(2.3)配置切点
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.chenyu.springframework.test.bean.UserService.*(..))"));

        //3.使用代理信息去获取 代理对象
        IUserService proxyObjectByJdk =(IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxyObjectByJdk.queryUserInfo());
    }

}
