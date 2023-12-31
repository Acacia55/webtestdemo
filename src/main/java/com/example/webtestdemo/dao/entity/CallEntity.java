package com.example.webtestdemo.dao.entity;

import java.io.Serializable;

public class CallEntity implements Serializable {

    private String userid;

    private String usersname;

    private String phonenumber;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return usersname;
    }

    public void setName(String usersname) {
        this.usersname = usersname;
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
                ", name='" + usersname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
