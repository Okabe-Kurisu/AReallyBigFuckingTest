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
        "values (#{id,jdbcType=BIGINT}, #{user,jdbcType=VARCHAR}, ",
        "#{host,jdbcType=VARCHAR}, #{db,jdbcType=VARCHAR}, #{command,jdbcType=VARCHAR}, ",
        "#{time,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR}, #{info,jdbcType=LONGVARCHAR})"
    })
    int insert(Processlist record);

    @Select({
        "select",
        "ID, USER, HOST, DB, COMMAND, TIME, STATE, INFO",
        "from PROCESSLIST"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="USER", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="HOST", property="host", jdbcType=JdbcType.VARCHAR),
        @Result(column="DB", property="db", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMAND", property="command", jdbcType=JdbcType.VARCHAR),
        @Result(column="TIME", property="time", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="INFO", property="info", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Processlist> selectAll();
}