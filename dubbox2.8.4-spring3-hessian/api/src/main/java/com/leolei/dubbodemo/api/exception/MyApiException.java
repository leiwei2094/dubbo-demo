package com.leolei.dubbodemo.api.exception;

public class MyApiException extends Exception {

    private String id;
    private String name;

    public MyApiException(String msg, String id, String name){
        super(msg);
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
