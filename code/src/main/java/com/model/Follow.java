package com.model;

public class Follow {
    private Integer fid;

    private Integer userId;

    private Boolean type;

    private Integer followedId;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }
}