package com.chenyu.springframework.test.bean.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试用的bean
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class UserDao {

    private static Map<String,String> hashMap=new HashMap<>();

    static {
        hashMap.put("10001","宸宇test1");
        hashMap.put("10002","宸宇test2");
    }

    public String queryUserName(String uid){
        return hashMap.get(uid);
    }

}
