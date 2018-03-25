package com.model;

public class Message {
    private Integer mid;

    private Integer user_id;

    private Integer accpeter_id;

    private Integer date;

    private Boolean is_read;

    private String content;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAccpeter_id() {
        return accpeter_id;
    }

    public void setAccpeter_id(Integer accpeter_id) {
        this.accpeter_id = accpeter_id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Boolean getIs_read() {
        return is_read;
    }

    public void setIs_read(Boolean is_read) {
        this.is_read = is_read;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}