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
        "values (#{tableCatalog,jdbcType=VARCHAR}, #{tableSchema,jdbcType=VARCHAR}, ",
        "#{tableName,jdbcType=VARCHAR}, #{nonUnique,jdbcType=BIGINT}, ",
        "#{indexSchema,jdbcType=VARCHAR}, #{indexName,jdbcType=VARCHAR}, ",
        "#{seqInIndex,jdbcType=BIGINT}, #{columnName,jdbcType=VARCHAR}, ",
        "#{collation,jdbcType=VARCHAR}, #{cardinality,jdbcType=BIGINT}, ",
        "#{subPart,jdbcType=BIGINT}, #{packed,jdbcType=VARCHAR}, ",
        "#{nullable,jdbcType=VARCHAR}, #{indexType,jdbcType=VARCHAR}, ",
        "#{comment,jdbcType=VARCHAR}, #{indexComment,jdbcType=VARCHAR})"
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
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="NON_UNIQUE", property="nonUnique", jdbcType=JdbcType.BIGINT),
        @Result(column="INDEX_SCHEMA", property="indexSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_NAME", property="indexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEQ_IN_INDEX", property="seqInIndex", jdbcType=JdbcType.BIGINT),
        @Result(column="COLUMN_NAME", property="columnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION", property="collation", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARDINALITY", property="cardinality", jdbcType=JdbcType.BIGINT),
        @Result(column="SUB_PART", property="subPart", jdbcType=JdbcType.BIGINT),
        @Result(column="PACKED", property="packed", jdbcType=JdbcType.VARCHAR),
        @Result(column="NULLABLE", property="nullable", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_TYPE", property="indexType", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMMENT", property="comment", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_COMMENT", property="indexComment", jdbcType=JdbcType.VARCHAR)
    })
    List<Statistics> selectAll();
}