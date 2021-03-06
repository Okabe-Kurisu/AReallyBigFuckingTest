package com.action;

import com.DAO.BlogDao;
import com.DAO.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.DataTool;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amadeus on 2018/5/13.
 */
@Namespace("/data")
@ParentPackage("json-default")
@Results( { @Result(name = ActionSupport.SUCCESS, type = "json", params = {"root", "resultMap"}),
        @Result(name = ActionSupport.ERROR, type = "json", params = {"root", "resultMap"})})
public class DataAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;
    String message;
    Map<String, Object> resultMap;


    //得到热门词汇
    @Action(value = "hotspot")
    public String getHotspot() {
        Map<String, Object> map = new HashMap();
        try {
            resultMap = PowerfulTools.format("200", "成功", DataTool.loadRtn(DataTool.Type.HotSPot.getPath()));
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            return ERROR;
        }
        return SUCCESS;
    }

    //得到热门搜索结果
    @Action(value = "getHotSearch")
    public String getHotSearch() {
        String keyword = request.getParameter("keyword");
        try {
            resultMap = PowerfulTools.format("200", "成功", DataTool.getHotSearch(keyword));
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            return ERROR;
        }
        return SUCCESS;
    }

    //得到热门用户
    @Action(value = "hotuser")
    public String getHotuser() {
        Map<String, Object> map = new HashMap();
        try {
            resultMap = PowerfulTools.format("200", "成功", UserDao.hotUser());//获得24小时有过评论转发和点赞的微博
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            return ERROR;
        }
        return SUCCESS;
    }


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    @Override
    public void setServletRequest(javax.servlet.http.HttpServletRequest request) {
        this.request = request;
    }
}