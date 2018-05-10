package com.mapper;

import com.model.Blog;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface BlogMapper {
    @Insert({
        "insert into blog (bid, user_id, ",
        "content, release_time, ",
        "type, comment_on, ",
        "visibility, is_edit, ",
        "ip_address, browser_sign, ",
        "is_showName, multimedia)",
        "values (#{bid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{release_time,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{comment_on,jdbcType=INTEGER}, ",
        "#{visibility,jdbcType=INTEGER}, #{is_edit,jdbcType=INTEGER}, ",
        "#{ip_address,jdbcType=VARCHAR}, #{browser_sign,jdbcType=VARCHAR}, ",
        "#{is_showName,jdbcType=INTEGER}, #{multimedia,jdbcType=LONGVARCHAR})"
    })
    int insert(Blog record);

    @Select({
        "select",
        "bid, user_id, content, release_time, type, comment_on, visibility, is_edit, ",
        "ip_address, browser_sign, is_showName, multimedia",
        "from blog"
    })
    @Results({
        @Result(column="bid", property="bid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_time", property="release_time", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_on", property="comment_on", jdbcType=JdbcType.INTEGER),
        @Result(column="visibility", property="visibility", jdbcType=JdbcType.INTEGER),
        @Result(column="is_edit", property="is_edit", jdbcType=JdbcType.INTEGER),
        @Result(column="ip_address", property="ip_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="browser_sign", property="browser_sign", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_showName", property="is_showName", jdbcType=JdbcType.INTEGER),
        @Result(column="multimedia", property="multimedia", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Blog> selectAll();
}