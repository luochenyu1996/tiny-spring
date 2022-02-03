package com.chenyu.springframework.core.io;

/**
 * 加载 Resource
 * @author chen yu
 * @create 2022-01-29 20:35
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 根据uri 包装出 Resource
     *
     */
    Resource getResource(String location);
}
