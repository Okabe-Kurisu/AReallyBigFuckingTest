package com.model;

/**
 * Created by Amadeus on 2018/3/22.
 */
public class Weibo {
    private int bid;
    private int uid;
    private int did;
    private String nickname;
    private String avatar;
    private String motto;
    private String content;
    private int thumbUpNum;
    private int commentNum;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getThumbUpNum() {
        return thumbUpNum;
    }

    public void setThumbUpNum(int thumbUpNum) {
        this.thumbUpNum = thumbUpNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
