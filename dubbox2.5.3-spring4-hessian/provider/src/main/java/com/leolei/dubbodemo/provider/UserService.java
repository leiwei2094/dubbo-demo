package com.leolei.dubbodemo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.leolei.dubbodemo.api.IUserService;
import com.leolei.dubbodemo.api.User;

public class UserService implements IUserService {
    @Override
    public User getUser(String name) {
        return new User(name);
    }
}
