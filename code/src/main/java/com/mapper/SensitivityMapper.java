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
        "type, details)",
        "values (#{sid,jdbcType=INTEGER}, #{blogId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{details,jdbcType=VARCHAR})"
    })
    int insert(Sensitivity record);

    @Select({
        "select",
        "sid, blog_id, type, details",
        "from sensitivity"
    })
    @Results({
        @Result(column="sid", property="sid", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blogId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR)
    })
    List<Sensitivity> selectAll();
}