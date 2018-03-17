package com.mapper;

import com.model.KeyColumnUsage;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface KeyColumnUsageMapper {
    @Insert({
        "insert into KEY_COLUMN_USAGE (CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, ",
        "CONSTRAINT_NAME, TABLE_CATALOG, ",
        "TABLE_SCHEMA, TABLE_NAME, ",
        "COLUMN_NAME, ORDINAL_POSITION, ",
        "POSITION_IN_UNIQUE_CONSTRAINT, REFERENCED_TABLE_SCHEMA, ",
        "REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME)",
        "values (#{CONSTRAINT_CATALOG,jdbcType=VARCHAR}, #{CONSTRAINT_SCHEMA,jdbcType=VARCHAR}, ",
        "#{CONSTRAINT_NAME,jdbcType=VARCHAR}, #{TABLE_CATALOG,jdbcType=VARCHAR}, ",
        "#{TABLE_SCHEMA,jdbcType=VARCHAR}, #{TABLE_NAME,jdbcType=VARCHAR}, ",
        "#{COLUMN_NAME,jdbcType=VARCHAR}, #{ORDINAL_POSITION,jdbcType=BIGINT}, ",
        "#{POSITION_IN_UNIQUE_CONSTRAINT,jdbcType=BIGINT}, #{REFERENCED_TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{REFERENCED_TABLE_NAME,jdbcType=VARCHAR}, #{REFERENCED_COLUMN_NAME,jdbcType=VARCHAR})"
    })
    int insert(KeyColumnUsage record);

    @Select({
        "select",
        "CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, CONSTRAINT_NAME, TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, POSITION_IN_UNIQUE_CONSTRAINT, REFERENCED_TABLE_SCHEMA, ",
        "REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME",
        "from KEY_COLUMN_USAGE"
    })
    @Results({
        @Result(column="CONSTRAINT_CATALOG", property="CONSTRAINT_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_SCHEMA", property="CONSTRAINT_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_NAME", property="CONSTRAINT_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_NAME", property="COLUMN_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDINAL_POSITION", property="ORDINAL_POSITION", jdbcType=JdbcType.BIGINT),
        @Result(column="POSITION_IN_UNIQUE_CONSTRAINT", property="POSITION_IN_UNIQUE_CONSTRAINT", jdbcType=JdbcType.BIGINT),
        @Result(column="REFERENCED_TABLE_SCHEMA", property="REFERENCED_TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="REFERENCED_TABLE_NAME", property="REFERENCED_TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="REFERENCED_COLUMN_NAME", property="REFERENCED_COLUMN_NAME", jdbcType=JdbcType.VARCHAR)
    })
    List<KeyColumnUsage> selectAll();
}