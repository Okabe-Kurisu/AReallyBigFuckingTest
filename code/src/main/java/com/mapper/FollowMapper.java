package com.mapper;

import com.model.Follow;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface FollowMapper {
    @Insert({
        "insert into follow (fid, user_id, ",
        "type, followed_id)",
        "values (#{fid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{followed_id,jdbcType=INTEGER})"
    })
    int insert(Follow record);

    @Select({
        "select",
        "fid, user_id, type, followed_id",
        "from follow"
    })
    @Results({
        @Result(column="fid", property="fid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="followed_id", property="followed_id", jdbcType=JdbcType.INTEGER)
    })
    List<Follow> selectAll();
}