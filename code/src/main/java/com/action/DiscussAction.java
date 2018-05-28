package com.action;

import com.DAO.DiscussDao;
import com.annotations.Authority;
import com.google.gson.Gson;
import com.model.Discuss;
import com.model.User;
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

/**
 * Created by Amadeus on 2018/4/12.
 */
@Namespace("/discuss")
@ParentPackage("custom-default")
public class DiscussAction extends ActionSupport implements ServletRequestAware {

    private Discuss discuss;

    private HttpServletRequest request;

    private String message;

    private List<String> dids;

    Map<String, Object> resultMap;

    @Action(value = "selectAllDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String selectAllDiscuss() {
        try {
            // 调用Dao层 获取数据
            List<Discuss> discussList = DiscussDao.selectAllDiscuss();

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", discussList);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "selectDiscussByUserid", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String selectDiscussByUserid() {
        try {

            //获得当前登录用户id
            User user = (User) request.getSession().getAttribute("user");
            int userId = user.getUid();
            int is_ban = user.getIs_ban();

            // 调用Dao层 获取数据
            List<Discuss> discusses = DiscussDao.selectDiscussByUserId(userId);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", discusses);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
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
            key = '%' + key + '%';
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
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String searchDiscuss() {
        String key, page, pageCap, flag;
        Map<String, Object> map = new HashMap<>();
        try {
            // 获取参数
            //key
            key = request.getParameter("key");
            if (key != null) key = '%' + key + '%';

            //分页参数
            page = request.getParameter("page");
            pageCap = request.getParameter("pageCap");
            // 计算分页 开始项和结束项
            if (null == page || "".equals(page)) page = "1";
            if (null == pageCap || "".equals(pageCap)) pageCap = "10";
            int pageN = Integer.parseInt(page);
            int pageC = Integer.parseInt(pageCap);
            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;

            //场景标识，判断是话题中心还是我的话题（0：话题中心，1：我的话题）
            flag = request.getParameter("discuss_page");
            if (null != flag && flag.equals("1")) {
                //获得当前登录用户id
                User user = (User) request.getSession().getAttribute("user");
                int userId = user.getUid();
                map.put("user_id", userId);
            }

            map.put("key", key);
            map.put("startNum", startNum);
            map.put("endNum", endNum);

            List<Discuss> discussList = DiscussDao.selectDiscuss(map);
            resultMap = PowerfulTools.format("200", "成功", discussList);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "selectHotDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String selectHotDiscuss() {
        try {
            List<Map> discussList = DiscussDao.selectHotDiscuss();
            resultMap = PowerfulTools.format("200", "成功", discussList);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getFollowDisBlog", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String getFollowDisBlog() {
        try {
            System.out.println(dids);
            if (dids == null || dids.size() < 1) throw new Exception("参数错误");
            List<Map> discussList = DiscussDao.selectFollowDisBlog(dids);
            resultMap = PowerfulTools.format("200", "成功", discussList);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "getBlogInDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    public String getBlogInDiscuss() {
        String key, did, page, pageCap;
        Map<String, Object> map = new HashMap<>();
        try {
            // 获得参数
            key = request.getParameter("keyword");
            if (key != null) key = '%' + key + '%';
            did = request.getParameter("did");

            if (did == null || "".equals(did)) throw new Exception("参数异常");

            page = request.getParameter("page");
            pageCap = request.getParameter("pageCap");

            // 计算分页 开始项和结束项
            if (null == page || "".equals(page)) page = "1";
            int pageN = Integer.parseInt(page);
            if (null == pageCap || "".equals(pageCap)) pageCap = "5";
            int pageC = Integer.parseInt(pageCap);

            int startNum = (pageN - 1) * pageC;
            int endNum = pageN * pageC;


            // 封装参数
            map.put("key", key);
            map.put("did", did);
            map.put("startNum", startNum);
            map.put("endNum", endNum);

            // 调用Dao层 获取数据
            List blogList = DiscussDao.selectBlogInDiscuss(map);

            // 封装响应数据
            resultMap = PowerfulTools.format("200", "成功", blogList);


        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "submitDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String submitDiscuss() {
        String name, detail, st_str;
        int start_time;

        Map<String, Object> map = new HashMap<>();
        try {
            //获得当前登录用户
            User user = (User) request.getSession().getAttribute("user");
            int userId = user.getUid();
            int is_ban = user.getIs_ban();
            int release_time = (int) (System.currentTimeMillis() / 1000);

            // 获得参数
            name = request.getParameter("name");
            detail = request.getParameter("detail");

            if (name == null || "".equals(name) || detail == null || "".equals(detail)) throw new Exception("参数错误");

            // 时间戳参数
            st_str = request.getParameter("start_time");
            if (st_str == null || "".equals(st_str)) start_time = (int) (System.currentTimeMillis() / 1000);
            else start_time = Integer.parseInt(st_str);

            // 封装请求数据
            map.put("name", name);
            map.put("user_id", userId);
            map.put("detail", detail);
            map.put("start_time", start_time);
            map.put("release_time", release_time);


            // 用户被封禁则无法插入
            if (is_ban != 0 || DiscussDao.insertDiscuss(map) == null) {
                throw new Exception("插入失败");
            }
            // 封装响应数据
            resultMap = PowerfulTools.format("200", "发布成功", null);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
        }
        return SUCCESS;
    }

    @Action(value = "updateDiscuss", results = {
            @Result(name = "success", type = "json", params = {"root", "resultMap"})
    })
    @Authority("")
    public String updateDiscuss() {
        //String name, user_id, detail, start_time, end_time, did;
        try {
            // 封装请求数据
//            name = request.getParameter("name");
//            user_id = request.getParameter("user_id");
//            detail = request.getParameter("detail");
//            start_time = request.getParameter("start_time");
//            end_time = request.getParameter("end_time");
//            did = request.getParameter("did");
//            discuss.setDid(Integer.parseInt(did));
//            discuss.setName(name);
//            discuss.setDetail(detail);
//            discuss.setUser_id(Integer.parseInt(user_id));
//            discuss.setStart_time(Integer.parseInt(start_time));
//            discuss.setEnd_time(Integer.parseInt(end_time));

            //获得当前登录用户id
            User user = (User) request.getSession().getAttribute("user");
            int userId = user.getUid();
            int is_ban = user.getIs_ban();

            if (discuss == null || discuss.getDid() == null) throw new Exception("参数错误");

            discuss.setUser_id(userId);
            System.out.println(discuss.toString());

            // 如果用户被封，或者用户不是指定话题的创建者则修改失败
            if (is_ban != 0 || DiscussDao.updateDiscuss(userId, discuss) == 0) {
                throw new Exception("插入失败");
            }
            resultMap = PowerfulTools.format("200", "成功", null);

        } catch (Exception ne) {
            ne.printStackTrace();
            resultMap = PowerfulTools.format("500", "系统异常", null);
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

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Discuss getDiscuss() {
        return discuss;
    }

    public void setDiscuss(Discuss discuss) {
        this.discuss = discuss;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public List<String> getDids() {
        return dids;
    }

    public void setDids(List<String> dids) {
        this.dids = dids;
    }
}
