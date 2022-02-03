package com.chenyu.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 接口实现类
 *
 * @author chen yu
 * @create 2022-01-29 20:36
 */
public class UrlResource  implements Resource{

     private  final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        URLConnection con = this.url.openConnection();

        try {
            return con.getInputStream();
        } catch (IOException e) {
            //出了异常 要关闭  http 连接
            if (con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw e;
        }
    }
}
