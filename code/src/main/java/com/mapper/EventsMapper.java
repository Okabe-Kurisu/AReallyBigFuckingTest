package com.mapper;

import com.model.Events;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface EventsMapper {
    @Insert({
        "insert into EVENTS (EVENT_CATALOG, EVENT_SCHEMA, ",
        "EVENT_NAME, DEFINER, ",
        "TIME_ZONE, EVENT_BODY, ",
        "EVENT_TYPE, EXECUTE_AT, ",
        "INTERVAL_VALUE, INTERVAL_FIELD, ",
        "SQL_MODE, STARTS, ",
        "ENDS, STATUS, ",
        "ON_COMPLETION, CREATED, ",
        "LAST_ALTERED, LAST_EXECUTED, ",
        "EVENT_COMMENT, ORIGINATOR, ",
        "CHARACTER_SET_CLIENT, COLLATION_CONNECTION, ",
        "DATABASE_COLLATION, EVENT_DEFINITION)",
        "values (#{EVENT_CATALOG,jdbcType=VARCHAR}, #{EVENT_SCHEMA,jdbcType=VARCHAR}, ",
        "#{EVENT_NAME,jdbcType=VARCHAR}, #{DEFINER,jdbcType=VARCHAR}, ",
        "#{TIME_ZONE,jdbcType=VARCHAR}, #{EVENT_BODY,jdbcType=VARCHAR}, ",
        "#{EVENT_TYPE,jdbcType=VARCHAR}, #{EXECUTE_AT,jdbcType=TIMESTAMP}, ",
        "#{INTERVAL_VALUE,jdbcType=VARCHAR}, #{INTERVAL_FIELD,jdbcType=VARCHAR}, ",
        "#{SQL_MODE,jdbcType=VARCHAR}, #{STARTS,jdbcType=TIMESTAMP}, ",
        "#{ENDS,jdbcType=TIMESTAMP}, #{STATUS,jdbcType=VARCHAR}, ",
        "#{ON_COMPLETION,jdbcType=VARCHAR}, #{CREATED,jdbcType=TIMESTAMP}, ",
        "#{LAST_ALTERED,jdbcType=TIMESTAMP}, #{LAST_EXECUTED,jdbcType=TIMESTAMP}, ",
        "#{EVENT_COMMENT,jdbcType=VARCHAR}, #{ORIGINATOR,jdbcType=BIGINT}, ",
        "#{CHARACTER_SET_CLIENT,jdbcType=VARCHAR}, #{COLLATION_CONNECTION,jdbcType=VARCHAR}, ",
        "#{DATABASE_COLLATION,jdbcType=VARCHAR}, #{EVENT_DEFINITION,jdbcType=LONGVARCHAR})"
    })
    int insert(Events record);

    @Select({
        "select",
        "EVENT_CATALOG, EVENT_SCHEMA, EVENT_NAME, DEFINER, TIME_ZONE, EVENT_BODY, EVENT_TYPE, ",
        "EXECUTE_AT, INTERVAL_VALUE, INTERVAL_FIELD, SQL_MODE, STARTS, ENDS, STATUS, ",
        "ON_COMPLETION, CREATED, LAST_ALTERED, LAST_EXECUTED, EVENT_COMMENT, ORIGINATOR, ",
        "CHARACTER_SET_CLIENT, COLLATION_CONNECTION, DATABASE_COLLATION, EVENT_DEFINITION",
        "from EVENTS"
    })
    @Results({
        @Result(column="EVENT_CATALOG", property="EVENT_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_SCHEMA", property="EVENT_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_NAME", property="EVENT_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFINER", property="DEFINER", jdbcType=JdbcType.VARCHAR),
        @Result(column="TIME_ZONE", property="TIME_ZONE", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_BODY", property="EVENT_BODY", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_TYPE", property="EVENT_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXECUTE_AT", property="EXECUTE_AT", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="INTERVAL_VALUE", property="INTERVAL_VALUE", jdbcType=JdbcType.VARCHAR),
        @Result(column="INTERVAL_FIELD", property="INTERVAL_FIELD", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_MODE", property="SQL_MODE", jdbcType=JdbcType.VARCHAR),
        @Result(column="STARTS", property="STARTS", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ENDS", property="ENDS", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATUS", property="STATUS", jdbcType=JdbcType.VARCHAR),
        @Result(column="ON_COMPLETION", property="ON_COMPLETION", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED", property="CREATED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_ALTERED", property="LAST_ALTERED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_EXECUTED", property="LAST_EXECUTED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EVENT_COMMENT", property="EVENT_COMMENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORIGINATOR", property="ORIGINATOR", jdbcType=JdbcType.BIGINT),
        @Result(column="CHARACTER_SET_CLIENT", property="CHARACTER_SET_CLIENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_CONNECTION", property="COLLATION_CONNECTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATABASE_COLLATION", property="DATABASE_COLLATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_DEFINITION", property="EVENT_DEFINITION", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Events> selectAll();
}