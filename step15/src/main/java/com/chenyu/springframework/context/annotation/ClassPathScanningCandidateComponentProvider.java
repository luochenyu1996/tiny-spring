package com.chenyu.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 扫描 注解 @Component
 *
 * @author chen yu
 * @create 2022-02-03 17:24
 */
public class ClassPathScanningCandidateComponentProvider {


    public Set<BeanDefinition>  findCandidateComponents(String basePackage){
        HashSet<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
