package com.action;

import com.DAO.UserDao;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.PowerfulTools;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.util.Map;

/**
 * Created by Amadeus on 2018/5/22.
 */
@ParentPackage("custom-default")
@Action("fileUpload")
@InterceptorRefs(value = { @InterceptorRef("fileUploadStack") })
@Results( { @Result(name = ActionSupport.SUCCESS, type = "json", params = {"root", "resultMap"}),
        @Result(name = ActionSupport.ERROR, type = "json", params = {"root", "resultMap"})})
public class UploadAction extends ActionSupport implements ServletRequestAware {

    private static final long serialVersionUID = 572146812454l;
    private static final int BUFFER_SIZE = 16 * 1024;
    // 封装上传文件域的属性
    private File upload;
    private HttpServletRequest request;
    // 封装上传文件类型的属性
    private String contentType;
    // 封装上传文件名的属性
    Map resultMap;
    private String fileName;
    private String storageFileName;

    // private String storagePath;

    // since we are using <s:file name="upload" ... /> the File itself will be
    // obtained through getter/setter of <file-tag-name>
    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public Map getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map resultMap) {
        this.resultMap = resultMap;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // since we are using <s:file name="upload" .../> the file name will be
    // obtained through getter/setter of <file-tag-name>FileName
    public String getUploadFileName() {
        return fileName;
    }

    public void setUploadFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStorageFileName() {
        return storageFileName;
    }

    public void setStorageFileName(String storageFileName) {
        this.storageFileName = storageFileName;
    }

    // since we are using <s:file name="upload" ... /> the content type will be
    // obtained through getter/setter of <file-tag-name>ContentType
    public String getUploadContentType() {
        return contentType;
    }

    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void copy(File src, File dst, File root) {
        if (!Files.exists(root.toPath())){
            root.mkdir();
        }
        try {
            Files.copy(src.toPath(), dst.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
    }

    @Override
    public String execute() throws Exception {
        storageFileName = System.currentTimeMillis()/1000 + fileName;
        File storageFile = new File(ServletActionContext.getServletContext()
                .getRealPath("/img/upload") + "/" + storageFileName);
        File root = new File(ServletActionContext.getServletContext()
                .getRealPath("/img/upload") );
        copy(upload, storageFile, root);
        String type = request.getParameter("type");
        String uid = request.getParameter("uid");
        String url = "/img/upload/" + storageFileName;
        if (type == "avatar"){
            User user = new User();
            user.setUid(Integer.parseInt(uid));
            user.setAvatar(url);
            UserDao.setImg(user);
        }else if (type == "background"){
            User user = new User();
            user.setUid(Integer.parseInt(uid));
            user.setBackground(url);
            UserDao.setImg(user);
        }
        resultMap = PowerfulTools.format("200", "成功", url);
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
