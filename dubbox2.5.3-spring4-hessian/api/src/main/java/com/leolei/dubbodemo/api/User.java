package com.leolei.dubbodemo.api;

public class User implements java.io.Serializable{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
