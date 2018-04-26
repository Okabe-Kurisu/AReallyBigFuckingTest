package com.action;

import com.DAO.BlogDao;
import com.DAO.SensitivityDao;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Namespace("/sensitivity")
@ParentPackage("json-default")
public class SensitivityAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;

    String message;
    //封禁账号
    @Action(value = "banByUserId", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String BanByUserId(){
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        String userid;
        String timestamp;
        try {
            // 获得参数
            userid = request.getParameter("userid");
            timestamp = request.getParameter("timestamp");
            // 封装参数
            map.put("userid", userid);//页面传过来的被封禁的账户id
            map.put("timestamp",timestamp);//页面传过来的封禁时间
            // 调用Dao层 封禁账号
            SensitivityDao.BanByUserId(map);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", map);
            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }catch (NullPointerException ne){
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }
    //解封账号
    @Action(value = "openByUserId", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String OpenByUserId(){
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        String userid;
        try {
            // 获得参数
            userid = request.getParameter("userid");;
            // 封装参数
            map.put("userid", userid);//页面传过来的解封账户id
            // 调用Dao层 解封账号
            SensitivityDao.OpenByUserId(map);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", map);
            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }catch (NullPointerException ne){
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return message;
    }
    //获得被举报的微博
    @Action(value = "getReportedBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public  String getReportedBlog() {
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            // 调用Dao层 获取数据
            List blogList = SensitivityDao.getReportedBlog();
            System.out.println(blogList.toString());
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);
            // 转换为JSON字符串
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
