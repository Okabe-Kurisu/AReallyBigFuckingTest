package com.action;

import com.DAO.DiscussDao;
import com.annotations.Authority;
import com.google.gson.Gson;
import com.model.Discuss;
import com.tool.PowerfulTools;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by Amadeus on 2018/4/12.
 */
@Namespace("/discuss")
@ParentPackage("custom-default")
public class DiscussAction {
    HttpServletRequest request;
    String message;

    @Action(value = "selectAllDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String selectAllDiscuss() {
        Map<String, Object> resultMap;
        try {
            // 调用Dao层 获取数据
            List<Discuss> discussList = DiscussDao.selectAllDiscuss();

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", discussList);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "quickQueryDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String quickQueryDiscuss() {
        Map<String, Object> resultMap;
        String key;
        try {
            key = request.getParameter("keyword");
            // 调用Dao层 获取数据
            List<Discuss> discussList = DiscussDao.quickQueryDiscuss(key);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", discussList);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "searchDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String searchDiscuss() {
        String keyword, page, pageCap;
        Map<String, Object> resultMap;
        String key;
        try {
            key = request.getParameter("keyword");
            Map<String, Object> map = new HashMap();
            page = request.getParameter("page");
            pageCap = request.getParameter("pageCap");
            map.put("key", key);

            // 计算分页 开始项和结束项
            if (null == page || "".equals(page)) page = "1";
            int pageN = Integer.parseInt(page);
            int pageC = Integer.parseInt(pageCap);

            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;
            map.put("startNum", startNum);
            map.put("endNum", endNum);
            List<Discuss> discussList = DiscussDao.selectDiscussLike(map);
            resultMap = PowerfulTools.format("200", "成功", discussList);

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "getFollowBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String getBlogInDiscuss() {
        String key, did;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            // 获得参数
            key = request.getParameter("keyword");
            did = request.getParameter("did");

            // 封装参数
            map.put("key", key);
            map.put("did", did);

            // 调用Dao层 获取数据
            List blogList = DiscussDao.selectBlogInDiscuss(map);

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

    @Action(value = "submitDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    @Authority("")
    public String submitDiscuss() {
        String name, user_id, detail;
        int start_time;
        Map<String, Object> resultMap;
        Map<String, Object> map = new HashMap<>();
        try {
            name = request.getParameter("name");
            user_id = request.getParameter("user_id");
            detail = request.getParameter("detail");
            start_time = (int) System.currentTimeMillis() / 1000;
            map.put("name", name);
            map.put("user_id", user_id);
            map.put("detail", detail);
            map.put("start_time", start_time);
            // 调用Dao层 获取数据
            if (DiscussDao.insertDiscuss(map) == null) {
                throw new Exception("插入失败");
            }
            resultMap = PowerfulTools.format("200", "成功");

            // 封装响应数据

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
        }
        return SUCCESS;
    }

    @Action(value = "updateDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String updateDiscuss() {
        String name, user_id, detail, start_time, end_time, did;
        Map<String, Object> resultMap;
        Discuss discuss = new Discuss();
        try {
            name = request.getParameter("name");
            user_id = request.getParameter("user_id");
            detail = request.getParameter("detail");
            start_time = request.getParameter("start_time");
            end_time = request.getParameter("end_time");
            did = request.getParameter("did");
            discuss.setDid(Integer.parseInt(did));
            discuss.setName(name);
            discuss.setDetail(detail);
            discuss.setUser_id(Integer.parseInt(user_id));
            discuss.setStart_time(Integer.parseInt(start_time));
            discuss.setEnd_time(Integer.parseInt(end_time));
            if (DiscussDao.updateDiscuss(discuss) == null) {
                throw new Exception("插入失败");
            }
            resultMap = PowerfulTools.format("200", "成功");

            // 封装响应数据

            // 转换为JSON字符串
            Gson gson = new Gson();
            message = gson.toJson(resultMap);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
            Gson gson = new Gson();
            message = gson.toJson(resultMap);
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

}