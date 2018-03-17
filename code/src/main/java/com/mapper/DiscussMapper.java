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
        "user_id, detail)",
        "values (#{did,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=INTEGER}, #{detail,jdbcType=VARCHAR})"
    })
    int insert(Discuss record);

    @Select({
        "select",
        "did, name, user_id, detail",
        "from discuss"
    })
    @Results({
        @Result(column="did", property="did", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR)
    })
    List<Discuss> selectAll();
}