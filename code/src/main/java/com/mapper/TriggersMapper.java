package com.mapper;

import com.model.Triggers;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface TriggersMapper {
    @Insert({
        "insert into TRIGGERS (TRIGGER_CATALOG, TRIGGER_SCHEMA, ",
        "TRIGGER_NAME, EVENT_MANIPULATION, ",
        "EVENT_OBJECT_CATALOG, EVENT_OBJECT_SCHEMA, ",
        "EVENT_OBJECT_TABLE, ACTION_ORDER, ",
        "ACTION_ORIENTATION, ACTION_TIMING, ",
        "ACTION_REFERENCE_OLD_TABLE, ACTION_REFERENCE_NEW_TABLE, ",
        "ACTION_REFERENCE_OLD_ROW, ACTION_REFERENCE_NEW_ROW, ",
        "CREATED, SQL_MODE, ",
        "DEFINER, CHARACTER_SET_CLIENT, ",
        "COLLATION_CONNECTION, DATABASE_COLLATION, ",
        "ACTION_CONDITION, ACTION_STATEMENT)",
        "values (#{TRIGGER_CATALOG,jdbcType=VARCHAR}, #{TRIGGER_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TRIGGER_NAME,jdbcType=VARCHAR}, #{EVENT_MANIPULATION,jdbcType=VARCHAR}, ",
        "#{EVENT_OBJECT_CATALOG,jdbcType=VARCHAR}, #{EVENT_OBJECT_SCHEMA,jdbcType=VARCHAR}, ",
        "#{EVENT_OBJECT_TABLE,jdbcType=VARCHAR}, #{ACTION_ORDER,jdbcType=BIGINT}, ",
        "#{ACTION_ORIENTATION,jdbcType=VARCHAR}, #{ACTION_TIMING,jdbcType=VARCHAR}, ",
        "#{ACTION_REFERENCE_OLD_TABLE,jdbcType=VARCHAR}, #{ACTION_REFERENCE_NEW_TABLE,jdbcType=VARCHAR}, ",
        "#{ACTION_REFERENCE_OLD_ROW,jdbcType=VARCHAR}, #{ACTION_REFERENCE_NEW_ROW,jdbcType=VARCHAR}, ",
        "#{CREATED,jdbcType=TIMESTAMP}, #{SQL_MODE,jdbcType=VARCHAR}, ",
        "#{DEFINER,jdbcType=VARCHAR}, #{CHARACTER_SET_CLIENT,jdbcType=VARCHAR}, ",
        "#{COLLATION_CONNECTION,jdbcType=VARCHAR}, #{DATABASE_COLLATION,jdbcType=VARCHAR}, ",
        "#{ACTION_CONDITION,jdbcType=LONGVARCHAR}, #{ACTION_STATEMENT,jdbcType=LONGVARCHAR})"
    })
    int insert(Triggers record);

    @Select({
        "select",
        "TRIGGER_CATALOG, TRIGGER_SCHEMA, TRIGGER_NAME, EVENT_MANIPULATION, EVENT_OBJECT_CATALOG, ",
        "EVENT_OBJECT_SCHEMA, EVENT_OBJECT_TABLE, ACTION_ORDER, ACTION_ORIENTATION, ACTION_TIMING, ",
        "ACTION_REFERENCE_OLD_TABLE, ACTION_REFERENCE_NEW_TABLE, ACTION_REFERENCE_OLD_ROW, ",
        "ACTION_REFERENCE_NEW_ROW, CREATED, SQL_MODE, DEFINER, CHARACTER_SET_CLIENT, ",
        "COLLATION_CONNECTION, DATABASE_COLLATION, ACTION_CONDITION, ACTION_STATEMENT",
        "from TRIGGERS"
    })
    @Results({
        @Result(column="TRIGGER_CATALOG", property="TRIGGER_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRIGGER_SCHEMA", property="TRIGGER_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRIGGER_NAME", property="TRIGGER_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_MANIPULATION", property="EVENT_MANIPULATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_OBJECT_CATALOG", property="EVENT_OBJECT_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_OBJECT_SCHEMA", property="EVENT_OBJECT_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="EVENT_OBJECT_TABLE", property="EVENT_OBJECT_TABLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_ORDER", property="ACTION_ORDER", jdbcType=JdbcType.BIGINT),
        @Result(column="ACTION_ORIENTATION", property="ACTION_ORIENTATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_TIMING", property="ACTION_TIMING", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_REFERENCE_OLD_TABLE", property="ACTION_REFERENCE_OLD_TABLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_REFERENCE_NEW_TABLE", property="ACTION_REFERENCE_NEW_TABLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_REFERENCE_OLD_ROW", property="ACTION_REFERENCE_OLD_ROW", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_REFERENCE_NEW_ROW", property="ACTION_REFERENCE_NEW_ROW", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED", property="CREATED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SQL_MODE", property="SQL_MODE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFINER", property="DEFINER", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_CLIENT", property="CHARACTER_SET_CLIENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_CONNECTION", property="COLLATION_CONNECTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATABASE_COLLATION", property="DATABASE_COLLATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTION_CONDITION", property="ACTION_CONDITION", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ACTION_STATEMENT", property="ACTION_STATEMENT", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Triggers> selectAll();
}