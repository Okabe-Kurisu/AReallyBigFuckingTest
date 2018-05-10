package com.mapper;

import com.model.BlogDiscuss;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface BlogDiscussMapper {
    @Insert({
        "insert into blog_discuss (bdid, blog_id, ",
        "discuss_id, user_id)",
        "values (#{bdid,jdbcType=INTEGER}, #{blog_id,jdbcType=INTEGER}, ",
        "#{discuss_id,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER})"
    })
    int insert(BlogDiscuss record);

    @Select({
        "select",
        "bdid, blog_id, discuss_id, user_id",
        "from blog_discuss"
    })
    @Results({
        @Result(column="bdid", property="bdid", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blog_id", jdbcType=JdbcType.INTEGER),
        @Result(column="discuss_id", property="discuss_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER)
    })
    List<BlogDiscuss> selectAll();
}