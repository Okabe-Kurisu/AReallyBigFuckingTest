package com.action;

import com.DAO.MessageDao;
import com.DAO.SensitivityDao;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
@Namespace("/message")
@ParentPackage("json-default")
public class MessageAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;

    String message;
    //用户私信他人
    @Action(value = "sendMassage", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String SendMassage(){
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        String uid;//发送方的id
        String aid;//接收方的id
        String content;
        int date;
        try {
            //获得当前时间戳
            date = (int)System.currentTimeMillis();
            //获得参数
            uid = request.getParameter("uid");
            aid = request.getParameter("aid");
            content = request.getParameter("content");
            // 封装参数
            map.put("uid",uid);
            map.put("aid",aid);
            map.put("content",content);
            map.put("date",date);
            //  调用Dao层 发送私信
            MessageDao.sendMassage(map);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", null);
            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return message;
    }

     //获得发送私信用户的用户名
     @Action(value = "getSendMessageUserId", results = {
             @Result(name = "success", type = "json", params = {"root", "message"})
     })
     public  String GetSendMessageUserId() {
         Map<String, Object> map = new HashMap();
         Map<String, Object> resultMap;
         String uid;
         try {
             //获得参数
             uid = request.getParameter("uid");
             map.put("uid",uid);//传过来的是用户账号
             // 调用Dao层 获取数据
             List blogList = MessageDao.getSendMassageUserid(map);
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
     //通过用户id和发送方的id查看信息
     @Action(value = "GetMassageUseridAndAccpeter", results = {
             @Result(name = "success", type = "json", params = {"root", "message"})
     })
    public String GetMassageUseridAndAccpeter(){
         Map<String, Object> map = new HashMap();
         Map<String, Object> resultMap;
         String uid;//用户的id
         String sid;//发送方的id
         try {
             //获得参数
             uid = request.getParameter("uid");
             sid = request.getParameter("sid");
             map.put("uid",uid);//传过来的是用户账号
             map.put("sid",sid);//发送方的id
             // 调用Dao层 获取数据
             MessageDao.yesRead(map);
             List blogList = MessageDao.getMassageUseridAndAccpeter(map);
             // 封装响应数据
             resultMap = PowerfulTools.format("200", "成功", blogList);
             // 转换为JSON字符串
             Gson gson = new Gson();
             message = gson.toJson(resultMap);
         }catch (NullPointerException ne) {
             ne.printStackTrace();
             resultMap = PowerfulTools.format("500", "系统异常", null);
             Gson gson = new Gson();
             message = gson.toJson(resultMap);
         }
        return message;
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
    public static void main(String[] arge) {

    }
}