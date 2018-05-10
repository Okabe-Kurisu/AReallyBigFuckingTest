package com.model;

public class Message {
    private Integer mid;

    private Integer user_id;

    private Integer accpeter_id;

    private String content;

    private Integer date;

    private Integer is_read;

    private Integer is_showName;

    private Integer read_time;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getIs_read() {
        return is_read;
    }

    public void setIs_read(Integer is_read) {
        this.is_read = is_read;
    }

    public Integer getIs_showName() {
        return is_showName;
    }

    public void setIs_showName(Integer is_showName) {
        this.is_showName = is_showName;
    }

    public Integer getRead_time() {
        return read_time;
    }

    public void setRead_time(Integer read_time) {
        this.read_time = read_time;
    }
}