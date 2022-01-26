package com.chenyu.springframework.test.bean;

/**
 * 测试用的bean
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class UserService {
    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息:"+name);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
