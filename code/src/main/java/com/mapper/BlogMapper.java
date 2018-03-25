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
        "visibility, multimedia)",
        "values (#{bid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{release_time,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{comment_on,jdbcType=INTEGER}, ",
        "#{visibility,jdbcType=INTEGER}, #{multimedia,jdbcType=LONGVARCHAR})"
    })
    int insert(Blog record);

    @Select({
        "select",
        "bid, user_id, content, release_time, type, comment_on, visibility, multimedia",
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
        @Result(column="multimedia", property="multimedia", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Blog> selectAll();
}