package com.model;

public class Follow {
    private Integer fid;

    private Integer user_id;

    private Integer type;

    private Integer followed_id;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFollowed_id() {
        return followed_id;
    }

    public void setFollowed_id(Integer followed_id) {
        this.followed_id = followed_id;
    }
}