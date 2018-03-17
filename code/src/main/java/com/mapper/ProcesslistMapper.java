package com.mapper;

import com.model.Processlist;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ProcesslistMapper {
    @Insert({
        "insert into PROCESSLIST (ID, USER, ",
        "HOST, DB, COMMAND, ",
        "TIME, STATE, INFO)",
        "values (#{ID,jdbcType=BIGINT}, #{USER,jdbcType=VARCHAR}, ",
        "#{HOST,jdbcType=VARCHAR}, #{DB,jdbcType=VARCHAR}, #{COMMAND,jdbcType=VARCHAR}, ",
        "#{TIME,jdbcType=INTEGER}, #{STATE,jdbcType=VARCHAR}, #{INFO,jdbcType=LONGVARCHAR})"
    })
    int insert(Processlist record);

    @Select({
        "select",
        "ID, USER, HOST, DB, COMMAND, TIME, STATE, INFO",
        "from PROCESSLIST"
    })
    @Results({
        @Result(column="ID", property="ID", jdbcType=JdbcType.BIGINT),
        @Result(column="USER", property="USER", jdbcType=JdbcType.VARCHAR),
        @Result(column="HOST", property="HOST", jdbcType=JdbcType.VARCHAR),
        @Result(column="DB", property="DB", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMAND", property="COMMAND", jdbcType=JdbcType.VARCHAR),
        @Result(column="TIME", property="TIME", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="STATE", jdbcType=JdbcType.VARCHAR),
        @Result(column="INFO", property="INFO", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Processlist> selectAll();
}