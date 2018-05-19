package com.model;

public class User {
    private Integer uid;

    private String username;

    private String nickname;

    private String password;

    private Integer sex;

    private Integer age;

    private Integer is_ns;

    private String motto;

    private String avatar;

    private String background;

    private Integer is_ban;

    private Integer alive;

    private String ip_address;

    private Integer last_logtime;

    private String browser_sign;

    private Integer weight;

    private String keyword;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIs_ns() {
        return is_ns;
    }

    public void setIs_ns(Integer is_ns) {
        this.is_ns = is_ns;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto == null ? null : motto.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    public Integer getIs_ban() {
        return is_ban;
    }

    public void setIs_ban(Integer is_ban) {
        this.is_ban = is_ban;
    }

    public Integer getAlive() {
        return alive;
    }

    public void setAlive(Integer alive) {
        this.alive = alive;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address == null ? null : ip_address.trim();
    }

    public Integer getLast_logtime() {
        return last_logtime;
    }

    public void setLast_logtime(Integer last_logtime) {
        this.last_logtime = last_logtime;
    }

    public String getBrowser_sign() {
        return browser_sign;
    }

    public void setBrowser_sign(String browser_sign) {
        this.browser_sign = browser_sign == null ? null : browser_sign.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}