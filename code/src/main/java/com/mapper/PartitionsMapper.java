package com.mapper;

import com.model.Partitions;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface PartitionsMapper {
    @Insert({
        "insert into PARTITIONS (TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, PARTITION_NAME, ",
        "SUBPARTITION_NAME, PARTITION_ORDINAL_POSITION, ",
        "SUBPARTITION_ORDINAL_POSITION, PARTITION_METHOD, ",
        "SUBPARTITION_METHOD, TABLE_ROWS, ",
        "AVG_ROW_LENGTH, DATA_LENGTH, ",
        "MAX_DATA_LENGTH, INDEX_LENGTH, ",
        "DATA_FREE, CREATE_TIME, ",
        "UPDATE_TIME, CHECK_TIME, ",
        "CHECKSUM, PARTITION_COMMENT, ",
        "NODEGROUP, TABLESPACE_NAME, ",
        "PARTITION_EXPRESSION, SUBPARTITION_EXPRESSION, ",
        "PARTITION_DESCRIPTION)",
        "values (#{TABLE_CATALOG,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{PARTITION_NAME,jdbcType=VARCHAR}, ",
        "#{SUBPARTITION_NAME,jdbcType=VARCHAR}, #{PARTITION_ORDINAL_POSITION,jdbcType=BIGINT}, ",
        "#{SUBPARTITION_ORDINAL_POSITION,jdbcType=BIGINT}, #{PARTITION_METHOD,jdbcType=VARCHAR}, ",
        "#{SUBPARTITION_METHOD,jdbcType=VARCHAR}, #{TABLE_ROWS,jdbcType=BIGINT}, ",
        "#{AVG_ROW_LENGTH,jdbcType=BIGINT}, #{DATA_LENGTH,jdbcType=BIGINT}, ",
        "#{MAX_DATA_LENGTH,jdbcType=BIGINT}, #{INDEX_LENGTH,jdbcType=BIGINT}, ",
        "#{DATA_FREE,jdbcType=BIGINT}, #{CREATE_TIME,jdbcType=TIMESTAMP}, ",
        "#{UPDATE_TIME,jdbcType=TIMESTAMP}, #{CHECK_TIME,jdbcType=TIMESTAMP}, ",
        "#{CHECKSUM,jdbcType=BIGINT}, #{PARTITION_COMMENT,jdbcType=VARCHAR}, ",
        "#{NODEGROUP,jdbcType=VARCHAR}, #{TABLESPACE_NAME,jdbcType=VARCHAR}, ",
        "#{PARTITION_EXPRESSION,jdbcType=LONGVARCHAR}, #{SUBPARTITION_EXPRESSION,jdbcType=LONGVARCHAR}, ",
        "#{PARTITION_DESCRIPTION,jdbcType=LONGVARCHAR})"
    })
    int insert(Partitions record);

    @Select({
        "select",
        "TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, PARTITION_NAME, SUBPARTITION_NAME, ",
        "PARTITION_ORDINAL_POSITION, SUBPARTITION_ORDINAL_POSITION, PARTITION_METHOD, ",
        "SUBPARTITION_METHOD, TABLE_ROWS, AVG_ROW_LENGTH, DATA_LENGTH, MAX_DATA_LENGTH, ",
        "INDEX_LENGTH, DATA_FREE, CREATE_TIME, UPDATE_TIME, CHECK_TIME, CHECKSUM, PARTITION_COMMENT, ",
        "NODEGROUP, TABLESPACE_NAME, PARTITION_EXPRESSION, SUBPARTITION_EXPRESSION, PARTITION_DESCRIPTION",
        "from PARTITIONS"
    })
    @Results({
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARTITION_NAME", property="PARTITION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUBPARTITION_NAME", property="SUBPARTITION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARTITION_ORDINAL_POSITION", property="PARTITION_ORDINAL_POSITION", jdbcType=JdbcType.BIGINT),
        @Result(column="SUBPARTITION_ORDINAL_POSITION", property="SUBPARTITION_ORDINAL_POSITION", jdbcType=JdbcType.BIGINT),
        @Result(column="PARTITION_METHOD", property="PARTITION_METHOD", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUBPARTITION_METHOD", property="SUBPARTITION_METHOD", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_ROWS", property="TABLE_ROWS", jdbcType=JdbcType.BIGINT),
        @Result(column="AVG_ROW_LENGTH", property="AVG_ROW_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_LENGTH", property="DATA_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="MAX_DATA_LENGTH", property="MAX_DATA_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="INDEX_LENGTH", property="INDEX_LENGTH", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_FREE", property="DATA_FREE", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="CREATE_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="UPDATE_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CHECK_TIME", property="CHECK_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CHECKSUM", property="CHECKSUM", jdbcType=JdbcType.BIGINT),
        @Result(column="PARTITION_COMMENT", property="PARTITION_COMMENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="NODEGROUP", property="NODEGROUP", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLESPACE_NAME", property="TABLESPACE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARTITION_EXPRESSION", property="PARTITION_EXPRESSION", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="SUBPARTITION_EXPRESSION", property="SUBPARTITION_EXPRESSION", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="PARTITION_DESCRIPTION", property="PARTITION_DESCRIPTION", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Partitions> selectAll();
}