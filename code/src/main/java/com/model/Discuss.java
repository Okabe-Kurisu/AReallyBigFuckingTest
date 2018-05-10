package com.model;

public class Discuss {
    private Integer did;

    private String name;

    private Integer user_id;

    private String detail;

    private Integer start_time;

    private Integer end_time;

    private Integer visibility;

    private Integer release_time;

    private Integer is_edit;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getStart_time() {
        return start_time;
    }

    public void setStart_time(Integer start_time) {
        this.start_time = start_time;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Integer release_time) {
        this.release_time = release_time;
    }

    public Integer getIs_edit() {
        return is_edit;
    }

    public void setIs_edit(Integer is_edit) {
        this.is_edit = is_edit;
    }
}