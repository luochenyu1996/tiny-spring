package com.chenyu.springframework.core.io;


import java.io.IOException;
import java.io.InputStream;

/**
 * 配置文件加载
 *
 * 最终目的是获得输入流
 *
 * @author chen yu
 * @create 2022/1/26
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
