package com.example.webtestdemo.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class DateEntity implements Serializable {

    private String id;

    private String userid;

    private Date time;

    private String content;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DateEntity{" +
                "userid='" + userid + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
