package cn.ziming.hello.spring.service.impl;

import cn.ziming.hello.spring.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void sayHi() {
        System.out.println("Hello Spring");
    }
}
