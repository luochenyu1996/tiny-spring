package com.chenyu.springframework.core.io;

/**
 * 资源加载器
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface ResourceLoader {
    //现阶段 只设置 classPath

    String  CLASSPATH_URL_PREFIX="classpath:";

    Resource getResource(String  location);
}
