package com.chenyu.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对配置文件进行转换
 *
 * @author chen yu
 * @create 2022-01-29 20:35
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
