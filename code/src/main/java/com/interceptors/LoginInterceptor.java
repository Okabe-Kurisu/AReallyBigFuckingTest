/**
 * @Description: 用户合法性验证
 * @author: 5776范仲旭
 * @date: 2018-04-26 9:10
 **/
package com.interceptors;

import com.annotations.Authority;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName: LoginInterceptor
 * @Description: 用户合法性验证
 * @author: 5776范仲旭
 * @date: 2018-04-26 9:10
 **/

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String methodName = invocation.getProxy().getMethod();
        Class clazz = invocation.getAction().getClass(); // 获取类对象
        Method currentMethod = clazz.getMethod(methodName); //获取拦截的方法

        //方法上添加了注解
        if (currentMethod.isAnnotationPresent(Authority.class)) {
            // 取得当前请求的注解的action
            ActionContext context = invocation.getInvocationContext();
            Map session = context.getSession();
            //Constants.UserName=="UserName"
            String user = (String) session.get("user");

            System.err.println("拦截器起作用");
            if (user == null) // 未登陆，跳转到登录页
            {
                System.err.println("进入拦截器：未登陆");
                context.put("tip", "你还没有登录");
                return Action.LOGIN;
            } else {   //已登录，继续后续流程
                System.err.println("进入拦截器：已登录");
                return invocation.invoke();
            }
        } else {
            System.err.println("进入拦截器：没有使用注解");
            return invocation.invoke();
        }
    }

}
