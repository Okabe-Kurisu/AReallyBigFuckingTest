package com.mapper;

import com.model.SessionVariables;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface SessionVariablesMapper {
    @Insert({
        "insert into SESSION_VARIABLES (VARIABLE_NAME, VARIABLE_VALUE)",
        "values (#{VARIABLE_NAME,jdbcType=VARCHAR}, #{VARIABLE_VALUE,jdbcType=VARCHAR})"
    })
    int insert(SessionVariables record);

    @Select({
        "select",
        "VARIABLE_NAME, VARIABLE_VALUE",
        "from SESSION_VARIABLES"
    })
    @Results({
        @Result(column="VARIABLE_NAME", property="VARIABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="VARIABLE_VALUE", property="VARIABLE_VALUE", jdbcType=JdbcType.VARCHAR)
    })
    List<SessionVariables> selectAll();
}