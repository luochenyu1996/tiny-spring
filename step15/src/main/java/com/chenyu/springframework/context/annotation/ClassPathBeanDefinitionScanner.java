package com.chenyu.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.chenyu.springframework.stereotype.Component;

import java.util.Set;

/**
 * 注解扫描
 *
 *
 * @author chen yu
 * @create 2022-02-03 17:35
 */
public class ClassPathBeanDefinitionScanner   extends ClassPathScanningCandidateComponentProvider{
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages){
        for (String basePackage : basePackages) {
            //使用父类中的方法 扫描到存在注解@Component的类
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 bean 的作用域 通过注解的方式
                String beanScope = resolveBeanScope(beanDefinition);
                if(StrUtil.isNotEmpty(beanScope)){
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        // 注册处理注解的 BeanPostProcessor（@Autowired、@Value）
        registry.registerBeanDefinition("com.chenyu.springframework.context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));

    }

     /**
      * 根据 beanDefinition 解析对象的作用 Scope 注解
      *
      */
     private  String resolveBeanScope(BeanDefinition beanDefinition){
         Class<?> beanClass = beanDefinition.getBeanClass();
         Scope scope = beanClass.getAnnotation(Scope.class);
         //获取注解
         if(null !=scope){
             return scope.value();
         }
         return StrUtil.EMPTY;
     }

     private  String   determineBeanName (BeanDefinition beanDefinition){
        Class<?> beanClass=  beanDefinition.getBeanClass();
         Component component = beanClass.getAnnotation(Component.class);
         String value = component.value();
         //如果是默认的话 ""   则大写字母变成小写
         if (StrUtil.isEmpty(value)) {
             value = StrUtil.lowerFirst(beanClass.getSimpleName());
         }
         //如果用混通过了注解进行配置的话 那么使用注解配置的值
         return value;
     }
}
