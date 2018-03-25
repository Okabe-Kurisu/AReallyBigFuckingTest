package com.action;

import com.DAO.BlogDao;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.ResultFormater;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于博客的action
 *
 * @author Zhongxu Fan
 * @create 2018-03-25 19:18
 **/

@Namespace("/blog")
@ParentPackage("json-default")
public class BlogAction extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request;

    String message;


    @Action(value = "searchBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "message"})
    })
    public String searchBlog() {
        String keyword, userid, pageNum, pageCap;
        long nowtime;
        Map<String, Object> map = new HashMap();
        Map<String, Object> resultMap;
        try {
            // 获得参数
            keyword = request.getParameter("keyword");
            pageNum = request.getParameter("pageNum");
            pageCap = request.getParameter("pageCap");
            userid = request.getParameter("userid");

            // 封装参数
            map.put("keyword", keyword);
            map.put("userid", userid);
            // 计算分页 开始项和结束项
            int pageN = Integer.parseInt(pageNum);
            int pageC = Integer.parseInt(pageCap);
            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;
            map.put("startNum", startNum);
            map.put("endNum", endNum);
            // 获得当前时间戳
            nowtime = new Date().getTime() / 1000;
            map.put("nowtime", nowtime);
            // 调用Dao层 获取数据
            List blogList = BlogDao.getBlogByKeyword(map);

            // 写入搜索记录(用户登陆状态下)
            if (userid != null && !"".equals(userid)) BlogDao.insertSearchBlog(map);

            // 封装响应数据
            resultMap = ResultFormater.format("200", "成功", blogList);

            // 转换为JSON字符串
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
