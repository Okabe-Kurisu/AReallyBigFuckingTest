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
        "values (#{TABLE_CATALOG,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{COLUMN_NAME,jdbcType=VARCHAR}, ",
        "#{ORDINAL_POSITION,jdbcType=BIGINT}, #{IS_NULLABLE,jdbcType=VARCHAR}, ",
        "#{DATA_TYPE,jdbcType=VARCHAR}, #{CHARACTER_MAXIMUM_LENGTH,jdbcType=BIGINT}, ",
        "#{CHARACTER_OCTET_LENGTH,jdbcType=BIGINT}, #{NUMERIC_PRECISION,jdbcType=BIGINT}, ",
        "#{NUMERIC_SCALE,jdbcType=BIGINT}, #{CHARACTER_SET_NAME,jdbcType=VARCHAR}, ",
        "#{COLLATION_NAME,jdbcType=VARCHAR}, #{COLUMN_KEY,jdbcType=VARCHAR}, ",
        "#{EXTRA,jdbcType=VARCHAR}, #{PRIVILEGES,jdbcType=VARCHAR}, ",
        "#{COLUMN_COMMENT,jdbcType=VARCHAR}, #{COLUMN_DEFAULT,jdbcType=LONGVARCHAR}, ",
        "#{COLUMN_TYPE,jdbcType=LONGVARCHAR})"
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
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_NAME", property="COLUMN_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDINAL_POSITION", property="ORDINAL_POSITION", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_NULLABLE", property="IS_NULLABLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="DATA_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_MAXIMUM_LENGTH", property="CHARACTER_MAXIMUM_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="CHARACTER_OCTET_LENGTH", property="CHARACTER_OCTET_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMERIC_PRECISION", property="NUMERIC_PRECISION", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMERIC_SCALE", property="NUMERIC_SCALE", jdbcType=JdbcType.BIGINT),
        @Result(column="CHARACTER_SET_NAME", property="CHARACTER_SET_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_NAME", property="COLLATION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_KEY", property="COLUMN_KEY", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA", property="EXTRA", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRIVILEGES", property="PRIVILEGES", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_COMMENT", property="COLUMN_COMMENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLUMN_DEFAULT", property="COLUMN_DEFAULT", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="COLUMN_TYPE", property="COLUMN_TYPE", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Columns> selectAll();
}