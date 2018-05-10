package com.mapper;

import com.model.Favorite;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface FavoriteMapper {
    @Insert({
        "insert into favorite (fid, user_id, ",
        "blog_id, time, visibility)",
        "values (#{fid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{blog_id,jdbcType=INTEGER}, #{time,jdbcType=INTEGER}, #{visibility,jdbcType=INTEGER})"
    })
    int insert(Favorite record);

    @Select({
        "select",
        "fid, user_id, blog_id, time, visibility",
        "from favorite"
    })
    @Results({
        @Result(column="fid", property="fid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blog_id", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.INTEGER),
        @Result(column="visibility", property="visibility", jdbcType=JdbcType.INTEGER)
    })
    List<Favorite> selectAll();
}