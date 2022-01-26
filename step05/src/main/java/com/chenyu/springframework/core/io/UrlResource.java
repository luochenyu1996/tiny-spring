package com.chenyu.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * url下的文件加载
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class UrlResource  implements  Resource{
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL  must be  not null");
        this.url = url;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException e) {
            //这里是释放了一下资源？
            if(con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();

            }
            throw  e;
        }
    }
}
