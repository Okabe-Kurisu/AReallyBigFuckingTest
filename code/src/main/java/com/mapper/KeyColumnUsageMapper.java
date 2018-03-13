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
        "values (#{constraintCatalog,jdbcType=VARCHAR}, #{constraintSchema,jdbcType=VARCHAR}, ",
        "#{constraintName,jdbcType=VARCHAR}, #{tableCatalog,jdbcType=VARCHAR}, ",
        "#{tableSchema,jdbcType=VARCHAR}, #{tableName,jdbcType=VARCHAR}, ",
        "#{columnName,jdbcType=VARCHAR}, #{ordinalPosition,jdbcType=BIGINT}, ",
        "#{positionInUniqueConstraint,jdbcType=BIGINT}, #{referencedTableSchema,jdbcType=VARCHAR}, ",
        "#{referencedTableName,jdbcType=VARCHAR}, #{referencedColumnName,jdbcType=VARCHAR})"
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
        @Result(column="CONSTRAINT_CATALOG", property="constraintCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_SCHEMA", property="constraintSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_NAME", property="constraintName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_NAME", property="columnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDINAL_POSITION", property="ordinalPosition", jdbcType=JdbcType.BIGINT),
        @Result(column="POSITION_IN_UNIQUE_CONSTRAINT", property="positionInUniqueConstraint", jdbcType=JdbcType.BIGINT),
        @Result(column="REFERENCED_TABLE_SCHEMA", property="referencedTableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="REFERENCED_TABLE_NAME", property="referencedTableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="REFERENCED_COLUMN_NAME", property="referencedColumnName", jdbcType=JdbcType.VARCHAR)
    })
    List<KeyColumnUsage> selectAll();
}