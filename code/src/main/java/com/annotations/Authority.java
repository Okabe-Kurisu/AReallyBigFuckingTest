/**
 * @Description: 自定义验证用户合法性注解
 * @author: 5776范仲旭
 * @date: 2018-04-26 9:15
 **/
package com.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: Authority
 * @Description: 自定义验证用户合法性注解
 * @author: 5776范仲旭
 * @date: 2018-04-26 9:15
 **/
@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Authority {
    /**
     * @return The namespace value.
     */
    String value();
}
