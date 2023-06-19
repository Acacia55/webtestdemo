package com.example.webtestdemo.dao.entity;

import java.io.Serializable;

public class BusEntity implements Serializable {

    private String userid;

    private String time;

    private String sit;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSit() {
        return sit;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }

    @Override
    public String toString() {
        return "BusEntity{" +
                "userid='" + userid + '\'' +
                ", time='" + time + '\'' +
                ", sit='" + sit + '\'' +
                '}';
    }
}
