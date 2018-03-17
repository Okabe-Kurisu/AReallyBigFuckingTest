package com.mapper;

import com.model.Statistics;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface StatisticsMapper {
    @Insert({
        "insert into STATISTICS (TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, NON_UNIQUE, ",
        "INDEX_SCHEMA, INDEX_NAME, ",
        "SEQ_IN_INDEX, COLUMN_NAME, ",
        "COLLATION, CARDINALITY, ",
        "SUB_PART, PACKED, ",
        "NULLABLE, INDEX_TYPE, ",
        "COMMENT, INDEX_COMMENT)",
        "values (#{TABLE_CATALOG,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{NON_UNIQUE,jdbcType=BIGINT}, ",
        "#{INDEX_SCHEMA,jdbcType=VARCHAR}, #{INDEX_NAME,jdbcType=VARCHAR}, ",
        "#{SEQ_IN_INDEX,jdbcType=BIGINT}, #{COLUMN_NAME,jdbcType=VARCHAR}, ",
        "#{COLLATION,jdbcType=VARCHAR}, #{CARDINALITY,jdbcType=BIGINT}, ",
        "#{SUB_PART,jdbcType=BIGINT}, #{PACKED,jdbcType=VARCHAR}, ",
        "#{NULLABLE,jdbcType=VARCHAR}, #{INDEX_TYPE,jdbcType=VARCHAR}, ",
        "#{COMMENT,jdbcType=VARCHAR}, #{INDEX_COMMENT,jdbcType=VARCHAR})"
    })
    int insert(Statistics record);

    @Select({
        "select",
        "TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, NON_UNIQUE, INDEX_SCHEMA, INDEX_NAME, ",
        "SEQ_IN_INDEX, COLUMN_NAME, COLLATION, CARDINALITY, SUB_PART, PACKED, NULLABLE, ",
        "INDEX_TYPE, COMMENT, INDEX_COMMENT",
        "from STATISTICS"
    })
    @Results({
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="NON_UNIQUE", property="NON_UNIQUE", jdbcType=JdbcType.BIGINT),
        @Result(column="INDEX_SCHEMA", property="INDEX_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_NAME", property="INDEX_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEQ_IN_INDEX", property="SEQ_IN_INDEX", jdbcType=JdbcType.BIGINT),
        @Result(column="COLUMN_NAME", property="COLUMN_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION", property="COLLATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARDINALITY", property="CARDINALITY", jdbcType=JdbcType.BIGINT),
        @Result(column="SUB_PART", property="SUB_PART", jdbcType=JdbcType.BIGINT),
        @Result(column="PACKED", property="PACKED", jdbcType=JdbcType.VARCHAR),
        @Result(column="NULLABLE", property="NULLABLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_TYPE", property="INDEX_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMENT", property="COMMENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_COMMENT", property="INDEX_COMMENT", jdbcType=JdbcType.VARCHAR)
    })
    List<Statistics> selectAll();
}