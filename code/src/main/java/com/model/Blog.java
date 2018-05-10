package com.model;

public class Blog {
    private Integer bid;

    private Integer user_id;

    private String content;

    private Integer release_time;

    private Integer type;

    private Integer comment_on;

    private Integer visibility;

    private Integer is_edit;

    private String ip_address;

    private String browser_sign;

    private Integer is_showName;

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

    public Integer getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Integer release_time) {
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

    public Integer getIs_edit() {
        return is_edit;
    }

    public void setIs_edit(Integer is_edit) {
        this.is_edit = is_edit;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address == null ? null : ip_address.trim();
    }

    public String getBrowser_sign() {
        return browser_sign;
    }

    public void setBrowser_sign(String browser_sign) {
        this.browser_sign = browser_sign == null ? null : browser_sign.trim();
    }

    public Integer getIs_showName() {
        return is_showName;
    }

    public void setIs_showName(Integer is_showName) {
        this.is_showName = is_showName;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia == null ? null : multimedia.trim();
    }
}