package com.mapper;

import com.model.Discuss;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface DiscussMapper {
    @Insert({
        "insert into discuss (did, name, ",
        "user_id, detail, ",
        "start_time, end_time)",
        "values (#{did,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=INTEGER}, #{detail,jdbcType=VARCHAR}, ",
        "#{start_time,jdbcType=INTEGER}, #{end_time,jdbcType=INTEGER})"
    })
    int insert(Discuss record);

    @Select({
        "select",
        "did, name, user_id, detail, start_time, end_time",
        "from discuss"
    })
    @Results({
        @Result(column="did", property="did", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="start_time", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time", property="end_time", jdbcType=JdbcType.INTEGER)
    })
    List<Discuss> selectAll();
}