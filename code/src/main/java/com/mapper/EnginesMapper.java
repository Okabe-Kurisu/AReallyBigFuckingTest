package com.mapper;

import com.model.Engines;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface EnginesMapper {
    @Insert({
        "insert into ENGINES (ENGINE, SUPPORT, ",
        "COMMENT, TRANSACTIONS, ",
        "XA, SAVEPOINTS)",
        "values (#{engine,jdbcType=VARCHAR}, #{support,jdbcType=VARCHAR}, ",
        "#{comment,jdbcType=VARCHAR}, #{transactions,jdbcType=VARCHAR}, ",
        "#{xa,jdbcType=VARCHAR}, #{savepoints,jdbcType=VARCHAR})"
    })
    int insert(Engines record);

    @Select({
        "select",
        "ENGINE, SUPPORT, COMMENT, TRANSACTIONS, XA, SAVEPOINTS",
        "from ENGINES"
    })
    @Results({
        @Result(column="ENGINE", property="engine", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUPPORT", property="support", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMENT", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRANSACTIONS", property="transactions", jdbcType=JdbcType.VARCHAR),
        @Result(column="XA", property="xa", jdbcType=JdbcType.VARCHAR),
        @Result(column="SAVEPOINTS", property="savepoints", jdbcType=JdbcType.VARCHAR)
    })
    List<Engines> selectAll();
}