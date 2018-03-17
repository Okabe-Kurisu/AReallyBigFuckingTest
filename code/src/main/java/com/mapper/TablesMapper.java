package com.mapper;

import com.model.Tables;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface TablesMapper {
    @Insert({
        "insert into TABLES (TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, TABLE_TYPE, ",
        "ENGINE, VERSION, ",
        "ROW_FORMAT, TABLE_ROWS, ",
        "AVG_ROW_LENGTH, DATA_LENGTH, ",
        "MAX_DATA_LENGTH, INDEX_LENGTH, ",
        "DATA_FREE, AUTO_INCREMENT, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "CHECK_TIME, TABLE_COLLATION, ",
        "CHECKSUM, CREATE_OPTIONS, ",
        "TABLE_COMMENT)",
        "values (#{TABLE_CATALOG,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{TABLE_TYPE,jdbcType=VARCHAR}, ",
        "#{ENGINE,jdbcType=VARCHAR}, #{VERSION,jdbcType=BIGINT}, ",
        "#{ROW_FORMAT,jdbcType=VARCHAR}, #{TABLE_ROWS,jdbcType=BIGINT}, ",
        "#{AVG_ROW_LENGTH,jdbcType=BIGINT}, #{DATA_LENGTH,jdbcType=BIGINT}, ",
        "#{MAX_DATA_LENGTH,jdbcType=BIGINT}, #{INDEX_LENGTH,jdbcType=BIGINT}, ",
        "#{DATA_FREE,jdbcType=BIGINT}, #{AUTO_INCREMENT,jdbcType=BIGINT}, ",
        "#{CREATE_TIME,jdbcType=TIMESTAMP}, #{UPDATE_TIME,jdbcType=TIMESTAMP}, ",
        "#{CHECK_TIME,jdbcType=TIMESTAMP}, #{TABLE_COLLATION,jdbcType=VARCHAR}, ",
        "#{CHECKSUM,jdbcType=BIGINT}, #{CREATE_OPTIONS,jdbcType=VARCHAR}, ",
        "#{TABLE_COMMENT,jdbcType=VARCHAR})"
    })
    int insert(Tables record);

    @Select({
        "select",
        "TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, ENGINE, VERSION, ROW_FORMAT, ",
        "TABLE_ROWS, AVG_ROW_LENGTH, DATA_LENGTH, MAX_DATA_LENGTH, INDEX_LENGTH, DATA_FREE, ",
        "AUTO_INCREMENT, CREATE_TIME, UPDATE_TIME, CHECK_TIME, TABLE_COLLATION, CHECKSUM, ",
        "CREATE_OPTIONS, TABLE_COMMENT",
        "from TABLES"
    })
    @Results({
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_TYPE", property="TABLE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENGINE", property="ENGINE", jdbcType=JdbcType.VARCHAR),
        @Result(column="VERSION", property="VERSION", jdbcType=JdbcType.BIGINT),
        @Result(column="ROW_FORMAT", property="ROW_FORMAT", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_ROWS", property="TABLE_ROWS", jdbcType=JdbcType.BIGINT),
        @Result(column="AVG_ROW_LENGTH", property="AVG_ROW_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_LENGTH", property="DATA_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="MAX_DATA_LENGTH", property="MAX_DATA_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="INDEX_LENGTH", property="INDEX_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_FREE", property="DATA_FREE", jdbcType=JdbcType.BIGINT),
        @Result(column="AUTO_INCREMENT", property="AUTO_INCREMENT", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="CREATE_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="UPDATE_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CHECK_TIME", property="CHECK_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TABLE_COLLATION", property="TABLE_COLLATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHECKSUM", property="CHECKSUM", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_OPTIONS", property="CREATE_OPTIONS", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_COMMENT", property="TABLE_COMMENT", jdbcType=JdbcType.VARCHAR)
    })
    List<Tables> selectAll();
}