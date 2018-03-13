package com.mapper;

import com.model.Columns;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ColumnsMapper {
    @Insert({
        "insert into COLUMNS (TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, COLUMN_NAME, ",
        "ORDINAL_POSITION, IS_NULLABLE, ",
        "DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, ",
        "CHARACTER_OCTET_LENGTH, NUMERIC_PRECISION, ",
        "NUMERIC_SCALE, CHARACTER_SET_NAME, ",
        "COLLATION_NAME, COLUMN_KEY, ",
        "EXTRA, PRIVILEGES, ",
        "COLUMN_COMMENT, COLUMN_DEFAULT, ",
        "COLUMN_TYPE)",
        "values (#{tableCatalog,jdbcType=VARCHAR}, #{tableSchema,jdbcType=VARCHAR}, ",
        "#{tableName,jdbcType=VARCHAR}, #{columnName,jdbcType=VARCHAR}, ",
        "#{ordinalPosition,jdbcType=BIGINT}, #{isNullable,jdbcType=VARCHAR}, ",
        "#{dataType,jdbcType=VARCHAR}, #{characterMaximumLength,jdbcType=BIGINT}, ",
        "#{characterOctetLength,jdbcType=BIGINT}, #{numericPrecision,jdbcType=BIGINT}, ",
        "#{numericScale,jdbcType=BIGINT}, #{characterSetName,jdbcType=VARCHAR}, ",
        "#{collationName,jdbcType=VARCHAR}, #{columnKey,jdbcType=VARCHAR}, ",
        "#{extra,jdbcType=VARCHAR}, #{privileges,jdbcType=VARCHAR}, ",
        "#{columnComment,jdbcType=VARCHAR}, #{columnDefault,jdbcType=LONGVARCHAR}, ",
        "#{columnType,jdbcType=LONGVARCHAR})"
    })
    int insert(Columns record);

    @Select({
        "select",
        "TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, IS_NULLABLE, ",
        "DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, CHARACTER_OCTET_LENGTH, NUMERIC_PRECISION, ",
        "NUMERIC_SCALE, CHARACTER_SET_NAME, COLLATION_NAME, COLUMN_KEY, EXTRA, PRIVILEGES, ",
        "COLUMN_COMMENT, COLUMN_DEFAULT, COLUMN_TYPE",
        "from COLUMNS"
    })
    @Results({
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_NAME", property="columnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDINAL_POSITION", property="ordinalPosition", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_NULLABLE", property="isNullable", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="dataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_MAXIMUM_LENGTH", property="characterMaximumLength", jdbcType=JdbcType.BIGINT),
        @Result(column="CHARACTER_OCTET_LENGTH", property="characterOctetLength", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMERIC_PRECISION", property="numericPrecision", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMERIC_SCALE", property="numericScale", jdbcType=JdbcType.BIGINT),
        @Result(column="CHARACTER_SET_NAME", property="characterSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_NAME", property="collationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_KEY", property="columnKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA", property="extra", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRIVILEGES", property="privileges", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_COMMENT", property="columnComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_DEFAULT", property="columnDefault", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="COLUMN_TYPE", property="columnType", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Columns> selectAll();
}