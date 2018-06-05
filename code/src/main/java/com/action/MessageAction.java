package com.action;

import com.DAO.MessageDao;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
@Namespace("/message")
@ParentPackage("json-default")
@Results( { @Result(name = ActionSupport.SUCCESS, type = "json", params = {"root", "resultMap"}),
        @Result(name = ActionSupport.ERROR, type = "json", params = {"root", "resultMap"})})
public class MessageAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    Map resultMap;
    String message;
    //用户私信他人
    @Action(value = "sendMassage")
    public String SendMassage(){
        Map<String, Object> map = new HashMap();
        String uid;//发送方的id
        String aid;//接收方的id
        String is_showName;//选择是否匿名
        String content;
        int date;
        try {
            //获得当前时间戳
            date = (int)(System.currentTimeMillis()/1000);
            //获得参数
            uid = request.getParameter("uid");
            aid = request.getParameter("aid");
            is_showName = request.getParameter("is_showName");
            content = request.getParameter("content");
            // 封装参数
            map.put("uid",uid);
            map.put("aid",aid);
            map.put("content",content);
            map.put("date",date);
            map.put("is_showName",is_showName);
            //  调用Dao层 发送私信
            MessageDao.sendMassage(map);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", null);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    //获得发送私信用户的用户名
    @Action(value = "getSendMessageUserId")
    public  String GetSendMessageUserId() {
        Map<String, Object> map = new HashMap();
        String uid;
        try {
            //获得参数
            uid = request.getParameter("uid");
            map.put("uid",uid);//传过来的是登录用户账号
            // 调用Dao层 获取数据
            List blogList = MessageDao.getSendMassageUserid(map);
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }
    //删除一整个会话
    @Action(value = "delSession")
    public  String delSession() {
        Map<String, Object> map = new HashMap();
        String uid, aid;
        try {
            uid = request.getParameter("uid");
            aid = request.getParameter("aid");
            map.put("uid",uid);//传过来的是登录用户账号
            map.put("aid",aid);
            MessageDao.delSession(map);
            resultMap = PowerfulTools.format("200", "成功", "");
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }
     //通过用户id和发送方的id查看信息
     @Action(value = "GetMassageUseridAndAccpeter")
    public String GetMassageUseridAndAccpeter(){
         Map<String, Object> map = new HashMap();
         String uid;//用户的id
         String sid;//发送方的id
         String is_showName;//选择是否查看匿名
         try {
             //获得参数
             uid = request.getParameter("uid");
             sid = request.getParameter("sid");
             is_showName = request.getParameter("is_showName");
             int idate = (int)(System.currentTimeMillis()/1000);
             map.put("uid",uid);//传过来的是用户账号
             map.put("sid",sid);//发送方的id
             map.put("idate",idate);//获得当前时间
             map.put("is_showName",is_showName);
             // 调用Dao层 获取数据
             List blogList = MessageDao.getMassageUseridAndAccpeter(map);
             // 封装响应数据
             resultMap = PowerfulTools.format("200", "成功", blogList);
         }catch (NullPointerException ne) {
             ne.printStackTrace();
             resultMap = PowerfulTools.format("500", "系统异常", null);
         }
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
    }
}
