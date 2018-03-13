package com.mapper;

import com.model.GlobalStatus;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface GlobalStatusMapper {
    @Insert({
        "insert into GLOBAL_STATUS (VARIABLE_NAME, VARIABLE_VALUE)",
        "values (#{variableName,jdbcType=VARCHAR}, #{variableValue,jdbcType=VARCHAR})"
    })
    int insert(GlobalStatus record);

    @Select({
        "select",
        "VARIABLE_NAME, VARIABLE_VALUE",
        "from GLOBAL_STATUS"
    })
    @Results({
        @Result(column="VARIABLE_NAME", property="variableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="VARIABLE_VALUE", property="variableValue", jdbcType=JdbcType.VARCHAR)
    })
    List<GlobalStatus> selectAll();
}