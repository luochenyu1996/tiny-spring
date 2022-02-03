package com.chenyu.springframework.aop.aspectj;

import com.chenyu.springframework.aop.Advisor;
import com.chenyu.springframework.aop.Pointcut;
import com.chenyu.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 *  包装切点、增强、切点表达式
 *
 *
 *
 * @author chen yu
 * @create 2022-01-31 22:21
 */
public class AspectJExpressionPointcutAdvisor  implements PointcutAdvisor {

    /**
     *  切面
     *
     */
    private AspectJExpressionPointcut pointcut;
    /**
     * 具体拦截方法
     *
     */
    private Advice advice;

    /**
     * 表达式
     *
     */
    private  String  expression;



    @Override
    public Pointcut getPointcut() {
        if(null==pointcut){
            pointcut=new AspectJExpressionPointcut(expression);
        }
        return  pointcut;
    }

    @Override
    public Advice getAdvice() {

        return advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
