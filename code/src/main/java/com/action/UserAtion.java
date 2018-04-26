package com.action;

import com.DAO.UserDao;
import com.google.gson.Gson;
import com.model.CallAt;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
