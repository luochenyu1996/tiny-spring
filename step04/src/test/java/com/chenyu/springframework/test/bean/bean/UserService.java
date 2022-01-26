package com.chenyu.springframework.test.bean.bean;

/**
 * 测试用的bean
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class UserService {
    private String userId;

    private  UserDao userDao;

    public UserService() {
    }

    public UserService(String name) {
        this.userId = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息:"+userDao.queryUserName(userId));
    }




}
