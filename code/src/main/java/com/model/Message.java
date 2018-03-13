package com.model;

import java.util.Date;

public class Message {
    private Integer mid;

    private Integer userId;

    private Integer accpeterId;

    private Date date;

    private Boolean isRead;

    private String content;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccpeterId() {
        return accpeterId;
    }

    public void setAccpeterId(Integer accpeterId) {
        this.accpeterId = accpeterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}