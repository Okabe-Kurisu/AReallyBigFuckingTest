package com.model;

import java.util.Date;

public class Blog {
    private Integer bid;

    private Integer userId;

    private String content;

    private Date releaseTime;

    private Boolean type;

    private Integer commentOn;

    private Boolean alive;

    private String multimedia;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getCommentOn() {
        return commentOn;
    }

    public void setCommentOn(Integer commentOn) {
        this.commentOn = commentOn;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia == null ? null : multimedia.trim();
    }
}