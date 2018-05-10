package com.model;

public class SearchLog {
    private Integer slid;

    private Integer user_id;

    private String content;

    private Integer date;

    private String ip_address;

    private String browser_sign;

    public Integer getSlid() {
        return slid;
    }

    public void setSlid(Integer slid) {
        this.slid = slid;
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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
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
}