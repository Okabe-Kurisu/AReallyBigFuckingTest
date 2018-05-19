package com.mapper;

import com.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Insert({
        "insert into user (uid, username, ",
        "nickname, password, ",
        "sex, age, is_ns, ",
        "motto, avatar, background, ",
        "is_ban, alive, ip_address, ",
        "last_logtime, browser_sign, ",
        "weight, keyword)",
        "values (#{uid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=INTEGER}, #{age,jdbcType=INTEGER}, #{is_ns,jdbcType=INTEGER}, ",
        "#{motto,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, #{background,jdbcType=VARCHAR}, ",
        "#{is_ban,jdbcType=INTEGER}, #{alive,jdbcType=INTEGER}, #{ip_address,jdbcType=VARCHAR}, ",
        "#{last_logtime,jdbcType=INTEGER}, #{browser_sign,jdbcType=VARCHAR}, ",
        "#{weight,jdbcType=INTEGER}, #{keyword,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @Select({
        "select",
        "uid, username, nickname, password, sex, age, is_ns, motto, avatar, background, ",
        "is_ban, alive, ip_address, last_logtime, browser_sign, weight, keyword",
        "from user"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="is_ns", property="is_ns", jdbcType=JdbcType.INTEGER),
        @Result(column="motto", property="motto", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="background", property="background", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_ban", property="is_ban", jdbcType=JdbcType.INTEGER),
        @Result(column="alive", property="alive", jdbcType=JdbcType.INTEGER),
        @Result(column="ip_address", property="ip_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_logtime", property="last_logtime", jdbcType=JdbcType.INTEGER),
        @Result(column="browser_sign", property="browser_sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="weight", property="weight", jdbcType=JdbcType.INTEGER),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectAll();
}