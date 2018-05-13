package com.action;

import com.DAO.DiscussDao;
import com.DAO.UserDao;
import com.google.gson.Gson;
import com.model.CallAt;
import com.model.Follow;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Amadeus on 2018/3/15.
 */
@Namespace("/user")
@ParentPackage("custom-default")
public class UserAtion extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request;

    User user;

    String message;


    @Action("addAdmin")
    public void addAdmin() {

    }

    @Action(value = "searchUser", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String searchUser() {
        String keyword, page, pageCap;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            keyword = request.getParameter("keyword");
            page = request.getParameter("page");
            pageCap = request.getParameter("pageCap");
            map.put("keyword", keyword);

            // 计算分页 开始项和结束项
            if (null == page || "".equals(page)) page = "1";
            int pageN = Integer.parseInt(page);
            int pageC = Integer.parseInt(pageCap);

            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;

            map.put("startNum", startNum);
            map.put("endNum", endNum);
            List userList = UserDao.getUserByKeyword(map);

            resultMap = PowerfulTools.format("200", "成功", userList);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "getFiveUser", results = {//@用户时获取5个用户
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String getFiveUser() {
        String nickname;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            nickname = request.getParameter("nickname");
            List<User> userList = UserDao.getFiveUser(nickname);

            resultMap = PowerfulTools.format("200", "获取用户", userList);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "addCallAt", results = {//将@用户添加到表中
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String addCallAt() {
        int user_id, bid;
        CallAt user = new CallAt();
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        //从前端获取
        user_id = Integer.parseInt(request.getParameter("user_id"));
        bid = Integer.parseInt(request.getParameter("bid"));
        try {
            user.setUser_id(user_id);
            user.setBlog_id(bid);
            user.setDate((int) (System.currentTimeMillis() / 1000));

            UserDao.addAtUser(user);
            resultMap = PowerfulTools.format("200", "@用户添加成功", null);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "signUp", results = {//判断用户名和昵称是否存在
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String signUp() {//判断用户名和昵称是否存在
        String username, nickname;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        username = request.getParameter("username");
        nickname = request.getParameter("nickname");
        try {
            if (UserDao.checkusername(username) == null && UserDao.checknickname(nickname) == null) {
                resultMap = PowerfulTools.format("200", "成功", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);
            } else {
                resultMap = PowerfulTools.format("101", "注册失败，该用户名或昵称已存在", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);
            }
        } catch (NullPointerException ne) {

        }
        return message;
    }

    @Action(value = "signIn", results = {//用户注册
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String signIn() {
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        String username, nickname, password;
        Integer age, sex;
        User user = new User();
        //从前端获取
        username = request.getParameter("username");
        nickname = request.getParameter("nickname");
        password = request.getParameter("password");
        age = Integer.parseInt(request.getParameter("age"));
        sex = Integer.parseInt(request.getParameter("sex"));
        Date day = new Date();//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        int logtime = Integer.parseInt((df.format(day)));
        String userAgent = request.getHeader("user-agent");//获取浏览器信息
        String ip = request.getHeader("X-Forwarded-For");//获取IP地址
        user.setUsername(username);
        user.setIs_ban(0);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setSex(sex);
        user.setAge(age);
        user.setLast_logtime(logtime);
        user.setIp_address(ip);
        user.setBrowser_sign(userAgent);

        try {
            if (UserDao.checkusername(username) == null && UserDao.checknickname(nickname) == null) {
                UserDao.signup(user);
                resultMap = PowerfulTools.format("200", "成功", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);
            } else {
                resultMap = PowerfulTools.format("101", "注册失败，该用户名或昵称已存在", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);

            }
        } catch (NullPointerException ne) {
            ne.printStackTrace();

        }
        return SUCCESS;
    }


    @Action(value = "login", results = {//用户登录
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String login() {
        String username, password;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        username = request.getParameter("username");
        password = request.getParameter("nickname");
        try {
            if (UserDao.checkusername(username) == null) {
                resultMap = PowerfulTools.format("101", "登录失败，该用户名不存在", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);
            } else if (UserDao.checkPassword(username).getPassword() == password) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                resultMap = PowerfulTools.format("200", "成功", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);
            } else {
                resultMap = PowerfulTools.format("101", "登录失败，密码错误", map);
                Gson gson = new Gson();
                message = gson.toJson(resultMap);
            }
        } catch (NullPointerException ne) {

        }
        return message;
    }

    @Action(value = "Update", results = {//修改用户
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String Update() {
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        String username, nickname, password;
        Integer age, sex;
        User user = new User();
        //从前端获取
        username = request.getParameter("username");
        nickname = request.getParameter("nickname");
        password = request.getParameter("password");
        age = Integer.parseInt(request.getParameter("age"));
        sex = Integer.parseInt(request.getParameter("sex"));
        Date day = new Date();//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        int logtime = Integer.parseInt((df.format(day)));
        String userAgent = request.getHeader("user-agent");//获取浏览器信息
        String ip = request.getHeader("X-Forwarded-For");//获取IP地址
        user.setUsername(username);
        user.setIs_ban(0);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setSex(sex);
        user.setAge(age);
        user.setLast_logtime(logtime);
        user.setIp_address(ip);
        try {
            resultMap = PowerfulTools.format("200", "成功", map);
            // 封装响应数据
            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {
        }
        return SUCCESS;
    }

    @Action(value = "leave", results = {//注销用户
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String leave() {//注销用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUid();
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            UserDao.userLeave(uid);
            resultMap = PowerfulTools.format("200", "注销成功", map);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {

        }
        return message;
    }
    @Action(value = "logout", results = {//用户退出登录
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String logout() {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            session.removeAttribute("user");
            resultMap = PowerfulTools.format("200", "退登成功", map);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {

        }
        return message;
    }
    @Action(value = "follow", results = {//关注用户
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String follow() {//注销用户
        int followed_id,user_id;
        followed_id =Integer.parseInt(request.getParameter("followed_id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user_id = user.getUid();
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        Date day = new Date();//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Follow follow  = new Follow();
        follow.setTime(Integer.parseInt((df.format(day))));
        follow.setType(0);
        follow.setVisibility(0);
        follow.setUser_id(user_id);
        follow.setFollowed_id(followed_id);
        try {
            UserDao.follow(follow);
            resultMap = PowerfulTools.format("200", "关注成功", map);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {

        }
            return message;

    }
    @Action(value = "unfollow", results = {////取消关注
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String unfollow() {
        int followed_id,user_id;
        followed_id =Integer.parseInt(request.getParameter("followed_id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user_id = user.getUid();
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        Follow follow  = new Follow();
        follow.setUser_id(user_id);
        follow.setFollowed_id(followed_id);
        try {
            UserDao.unfollow(follow);
            resultMap = PowerfulTools.format("200", "关注成功", map);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {

        }
        return message;

    }
    @Action(value = "initUser", results = {//清空用户微博
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String initUser() {
        int user_id;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            UserDao.initUser(user);
            resultMap = PowerfulTools.format("200", "关注成功", map);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {

        }
        return message;

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
    }
}
