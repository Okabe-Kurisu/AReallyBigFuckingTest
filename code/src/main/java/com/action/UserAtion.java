package com.action;

import com.DAO.UserDao;
import com.google.gson.Gson;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.ResultFormater;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amadeus on 2018/3/15.
 */
@Namespace("/user")
@ParentPackage("json-default")
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
            int pageN = Integer.parseInt(page);
            int pageC = Integer.parseInt(pageCap);

            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;

            map.put("startNum", startNum);
            map.put("endNum", endNum);
            List userList = UserDao.getUserByKeyword(map);

            resultMap = ResultFormater.format("200", "成功", userList);

            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = ResultFormater.format("500", "系统异常", null);

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
