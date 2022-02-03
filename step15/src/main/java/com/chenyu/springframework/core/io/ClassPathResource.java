package com.chenyu.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.chenyu.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 接口实现类
 *
 * @author chen yu
 * @create 2022-01-29 20:37
 */
public class ClassPathResource  implements  Resource{
     private final String path;

     private ClassLoader classLoader;


    public ClassPathResource(String path) {
        this(path,(ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader =(classLoader!=null?classLoader: ClassUtils.getClassLoader());
    }

    /**
     * 使用 classLoader 把 url 转化成 inputStream
     *
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if(is==null){
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
