package com.model;

import java.util.Date;

public class Blog {
    private Integer bid;

    private Integer user_id;

    private String content;

    private Date release_time;

    private Integer type;

    private Integer comment_on;

    private Integer visibility;

    private String multimedia;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getComment_on() {
        return comment_on;
    }

    public void setComment_on(Integer comment_on) {
        this.comment_on = comment_on;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia == null ? null : multimedia.trim();
    }
}