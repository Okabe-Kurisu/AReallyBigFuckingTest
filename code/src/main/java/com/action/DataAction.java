package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tool.HotSpot;
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



    @Action(value = "getHotSpot")

    public String getHS() {
        Map<String, Object> map = new HashMap();

        try {
            resultMap = PowerfulTools.format("200", "成功", HotSpot.loadRtn());
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