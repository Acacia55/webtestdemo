package com.example.webtestdemo.dao.entity;

import java.io.Serializable;

public class CallEntity implements Serializable {

    private String userid;

    private String name;

    private String phonenumber;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "CallEntity{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
