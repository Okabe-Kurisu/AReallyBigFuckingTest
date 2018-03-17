package com.action;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

/**
 * Created by Amadeus on 2018/3/15.
 */
@Namespace("/user")
public class UserAtion extends ActionSupport {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    User user;

    @Action("addAdmin")
    public void addAdmin (){

    }
}
