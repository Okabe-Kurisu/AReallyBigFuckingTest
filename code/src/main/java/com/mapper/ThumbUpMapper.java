package com.mapper;

import com.model.ThumbUp;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ThumbUpMapper {
    @Insert({
        "insert into thumb_up (tuid, user_id, ",
        "blog_id, date)",
        "values (#{tuid,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{blogId,jdbcType=INTEGER}, #{date,jdbcType=TIMESTAMP})"
    })
    int insert(ThumbUp record);

    @Select({
        "select",
        "tuid, user_id, blog_id, date",
        "from thumb_up"
    })
    @Results({
        @Result(column="tuid", property="tuid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blogId", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ThumbUp> selectAll();
}