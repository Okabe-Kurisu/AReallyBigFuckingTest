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
        "type, comment_on, alive, ",
        "multimedia)",
        "values (#{bid,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{releaseTime,jdbcType=TIMESTAMP}, ",
        "#{type,jdbcType=BIT}, #{commentOn,jdbcType=INTEGER}, #{alive,jdbcType=BIT}, ",
        "#{multimedia,jdbcType=LONGVARCHAR})"
    })
    int insert(Blog record);

    @Select({
        "select",
        "bid, user_id, content, release_time, type, comment_on, alive, multimedia",
        "from blog"
    })
    @Results({
        @Result(column="bid", property="bid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_time", property="releaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="comment_on", property="commentOn", jdbcType=JdbcType.INTEGER),
        @Result(column="alive", property="alive", jdbcType=JdbcType.BIT),
        @Result(column="multimedia", property="multimedia", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Blog> selectAll();
}