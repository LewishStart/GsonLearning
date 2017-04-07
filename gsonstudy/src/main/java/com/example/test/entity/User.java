package com.example.test.entity;

import com.google.gson.annotations.SerializedName;

/**
 * author: sundong
 * created at 2017/4/7 11:17
 */
public class User {
    //省略其它
    private String name;

    private int age;
    @SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
    private String emailAddress;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
