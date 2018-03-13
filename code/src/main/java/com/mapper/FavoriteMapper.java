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
        "blog_id)",
        "values (#{fid,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{blogId,jdbcType=INTEGER})"
    })
    int insert(Favorite record);

    @Select({
        "select",
        "fid, user_id, blog_id",
        "from favorite"
    })
    @Results({
        @Result(column="fid", property="fid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blogId", jdbcType=JdbcType.INTEGER)
    })
    List<Favorite> selectAll();
}