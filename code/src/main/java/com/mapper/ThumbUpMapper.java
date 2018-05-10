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
        "blog_id, date, t_id)",
        "values (#{tuid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{blog_id,jdbcType=INTEGER}, #{date,jdbcType=INTEGER}, #{t_id,jdbcType=INTEGER})"
    })
    int insert(ThumbUp record);

    @Select({
        "select",
        "tuid, user_id, blog_id, date, t_id",
        "from thumb_up"
    })
    @Results({
        @Result(column="tuid", property="tuid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blog_id", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.INTEGER),
        @Result(column="t_id", property="t_id", jdbcType=JdbcType.INTEGER)
    })
    List<ThumbUp> selectAll();
}