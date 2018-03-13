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
        "is_ban, alive)",
        "values (#{uid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=BIT}, #{age,jdbcType=TINYINT}, #{isNs,jdbcType=BIT}, ",
        "#{motto,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, #{background,jdbcType=VARCHAR}, ",
        "#{isBan,jdbcType=TIMESTAMP}, #{alive,jdbcType=BIT})"
    })
    int insert(User record);

    @Select({
        "select",
        "uid, username, nickname, password, sex, age, is_ns, motto, avatar, background, ",
        "is_ban, alive",
        "from user"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="age", property="age", jdbcType=JdbcType.TINYINT),
        @Result(column="is_ns", property="isNs", jdbcType=JdbcType.BIT),
        @Result(column="motto", property="motto", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="background", property="background", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_ban", property="isBan", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="alive", property="alive", jdbcType=JdbcType.BIT)
    })
    List<User> selectAll();
}