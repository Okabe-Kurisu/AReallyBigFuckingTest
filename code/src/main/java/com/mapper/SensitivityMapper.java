package com.mapper;

import com.model.Sensitivity;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface SensitivityMapper {
    @Insert({
        "insert into sensitivity (sid, blog_id, ",
        "type, details, user_id, ",
        "time, visibility)",
        "values (#{sid,jdbcType=INTEGER}, #{blog_id,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{details,jdbcType=VARCHAR}, #{user_id,jdbcType=INTEGER}, ",
        "#{time,jdbcType=INTEGER}, #{visibility,jdbcType=INTEGER})"
    })
    int insert(Sensitivity record);

    @Select({
        "select",
        "sid, blog_id, type, details, user_id, time, visibility",
        "from sensitivity"
    })
    @Results({
        @Result(column="sid", property="sid", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blog_id", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.INTEGER),
        @Result(column="visibility", property="visibility", jdbcType=JdbcType.INTEGER)
    })
    List<Sensitivity> selectAll();
}