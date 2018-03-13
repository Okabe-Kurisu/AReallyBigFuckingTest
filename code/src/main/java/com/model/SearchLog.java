package com.model;

import java.util.Date;

public class SearchLog {
    private Integer slid;

    private Integer userId;

    private String content;

    private Date date;

    public Integer getSlid() {
        return slid;
    }

    public void setSlid(Integer slid) {
        this.slid = slid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}