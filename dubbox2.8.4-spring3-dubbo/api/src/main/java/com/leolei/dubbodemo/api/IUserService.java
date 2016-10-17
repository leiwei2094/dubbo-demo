package com.leolei.dubbodemo.api;

public interface IUserService {

    User getUser(String name);

    String getName(User user);
}
