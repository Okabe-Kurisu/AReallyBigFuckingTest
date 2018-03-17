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
        "values (#{ENGINE,jdbcType=VARCHAR}, #{SUPPORT,jdbcType=VARCHAR}, ",
        "#{COMMENT,jdbcType=VARCHAR}, #{TRANSACTIONS,jdbcType=VARCHAR}, ",
        "#{XA,jdbcType=VARCHAR}, #{SAVEPOINTS,jdbcType=VARCHAR})"
    })
    int insert(Engines record);

    @Select({
        "select",
        "ENGINE, SUPPORT, COMMENT, TRANSACTIONS, XA, SAVEPOINTS",
        "from ENGINES"
    })
    @Results({
        @Result(column="ENGINE", property="ENGINE", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUPPORT", property="SUPPORT", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMENT", property="COMMENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRANSACTIONS", property="TRANSACTIONS", jdbcType=JdbcType.VARCHAR),
        @Result(column="XA", property="XA", jdbcType=JdbcType.VARCHAR),
        @Result(column="SAVEPOINTS", property="SAVEPOINTS", jdbcType=JdbcType.VARCHAR)
    })
    List<Engines> selectAll();
}