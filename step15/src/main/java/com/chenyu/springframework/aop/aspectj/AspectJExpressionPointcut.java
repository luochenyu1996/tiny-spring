package com.chenyu.springframework.aop.aspectj;

import com.chenyu.springframework.aop.ClassFilter;
import com.chenyu.springframework.aop.MethodMatcher;
import com.chenyu.springframework.aop.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Pointcut 实现
 *
 * 依赖AspectJ 做表达式匹配
 * 实现了MethodMatcher （匹配规则进行了实现）和ClassFilter 接口
 *
 * @author chen yu
 * @create 2022-01-31 22:21
 */
public class AspectJExpressionPointcut  implements Pointcut, ClassFilter, MethodMatcher {

    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES =new HashSet<>();

    /**
     * 引入的一依赖，用来做切入表达式匹配
     * 这就是用来过滤的具体的东西
     *
     */
    private final PointcutExpression pointcutExpression;


    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    /**
     * 构造函数
     *
     */
    public AspectJExpressionPointcut(String expression) {
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }


    /**
     * Class  匹配实现
     *
     */
    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    /**
     * Methods 匹配实现
     *
     * 如何进行的匹配：
     *
     *
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
