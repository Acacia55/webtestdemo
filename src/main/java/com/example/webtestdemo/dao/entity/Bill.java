package com.example.webtestdemo.dao.entity;

import java.io.Serializable;

public class Bill implements Serializable {

    private String id;
    private String userid;
    private String in;
    private String out;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", in='" + in + '\'' +
                ", out='" + out + '\'' +
                '}';
    }
}
