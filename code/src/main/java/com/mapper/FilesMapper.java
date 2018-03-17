package com.mapper;

import com.model.Files;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface FilesMapper {
    @Insert({
        "insert into FILES (FILE_ID, FILE_NAME, ",
        "FILE_TYPE, TABLESPACE_NAME, ",
        "TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, LOGFILE_GROUP_NAME, ",
        "LOGFILE_GROUP_NUMBER, ENGINE, ",
        "FULLTEXT_KEYS, DELETED_ROWS, ",
        "UPDATE_COUNT, FREE_EXTENTS, ",
        "TOTAL_EXTENTS, EXTENT_SIZE, ",
        "INITIAL_SIZE, MAXIMUM_SIZE, ",
        "AUTOEXTEND_SIZE, CREATION_TIME, ",
        "LAST_UPDATE_TIME, LAST_ACCESS_TIME, ",
        "RECOVER_TIME, TRANSACTION_COUNTER, ",
        "VERSION, ROW_FORMAT, ",
        "TABLE_ROWS, AVG_ROW_LENGTH, ",
        "DATA_LENGTH, MAX_DATA_LENGTH, ",
        "INDEX_LENGTH, DATA_FREE, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "CHECK_TIME, CHECKSUM, ",
        "STATUS, EXTRA)",
        "values (#{FILE_ID,jdbcType=BIGINT}, #{FILE_NAME,jdbcType=VARCHAR}, ",
        "#{FILE_TYPE,jdbcType=VARCHAR}, #{TABLESPACE_NAME,jdbcType=VARCHAR}, ",
        "#{TABLE_CATALOG,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{LOGFILE_GROUP_NAME,jdbcType=VARCHAR}, ",
        "#{LOGFILE_GROUP_NUMBER,jdbcType=BIGINT}, #{ENGINE,jdbcType=VARCHAR}, ",
        "#{FULLTEXT_KEYS,jdbcType=VARCHAR}, #{DELETED_ROWS,jdbcType=BIGINT}, ",
        "#{UPDATE_COUNT,jdbcType=BIGINT}, #{FREE_EXTENTS,jdbcType=BIGINT}, ",
        "#{TOTAL_EXTENTS,jdbcType=BIGINT}, #{EXTENT_SIZE,jdbcType=BIGINT}, ",
        "#{INITIAL_SIZE,jdbcType=BIGINT}, #{MAXIMUM_SIZE,jdbcType=BIGINT}, ",
        "#{AUTOEXTEND_SIZE,jdbcType=BIGINT}, #{CREATION_TIME,jdbcType=TIMESTAMP}, ",
        "#{LAST_UPDATE_TIME,jdbcType=TIMESTAMP}, #{LAST_ACCESS_TIME,jdbcType=TIMESTAMP}, ",
        "#{RECOVER_TIME,jdbcType=BIGINT}, #{TRANSACTION_COUNTER,jdbcType=BIGINT}, ",
        "#{VERSION,jdbcType=BIGINT}, #{ROW_FORMAT,jdbcType=VARCHAR}, ",
        "#{TABLE_ROWS,jdbcType=BIGINT}, #{AVG_ROW_LENGTH,jdbcType=BIGINT}, ",
        "#{DATA_LENGTH,jdbcType=BIGINT}, #{MAX_DATA_LENGTH,jdbcType=BIGINT}, ",
        "#{INDEX_LENGTH,jdbcType=BIGINT}, #{DATA_FREE,jdbcType=BIGINT}, ",
        "#{CREATE_TIME,jdbcType=TIMESTAMP}, #{UPDATE_TIME,jdbcType=TIMESTAMP}, ",
        "#{CHECK_TIME,jdbcType=TIMESTAMP}, #{CHECKSUM,jdbcType=BIGINT}, ",
        "#{STATUS,jdbcType=VARCHAR}, #{EXTRA,jdbcType=VARCHAR})"
    })
    int insert(Files record);

    @Select({
        "select",
        "FILE_ID, FILE_NAME, FILE_TYPE, TABLESPACE_NAME, TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, LOGFILE_GROUP_NAME, LOGFILE_GROUP_NUMBER, ENGINE, FULLTEXT_KEYS, ",
        "DELETED_ROWS, UPDATE_COUNT, FREE_EXTENTS, TOTAL_EXTENTS, EXTENT_SIZE, INITIAL_SIZE, ",
        "MAXIMUM_SIZE, AUTOEXTEND_SIZE, CREATION_TIME, LAST_UPDATE_TIME, LAST_ACCESS_TIME, ",
        "RECOVER_TIME, TRANSACTION_COUNTER, VERSION, ROW_FORMAT, TABLE_ROWS, AVG_ROW_LENGTH, ",
        "DATA_LENGTH, MAX_DATA_LENGTH, INDEX_LENGTH, DATA_FREE, CREATE_TIME, UPDATE_TIME, ",
        "CHECK_TIME, CHECKSUM, STATUS, EXTRA",
        "from FILES"
    })
    @Results({
        @Result(column="FILE_ID", property="FILE_ID", jdbcType=JdbcType.BIGINT),
        @Result(column="FILE_NAME", property="FILE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="FILE_TYPE", property="FILE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLESPACE_NAME", property="TABLESPACE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOGFILE_GROUP_NAME", property="LOGFILE_GROUP_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOGFILE_GROUP_NUMBER", property="LOGFILE_GROUP_NUMBER", jdbcType=JdbcType.BIGINT),
        @Result(column="ENGINE", property="ENGINE", jdbcType=JdbcType.VARCHAR),
        @Result(column="FULLTEXT_KEYS", property="FULLTEXT_KEYS", jdbcType=JdbcType.VARCHAR),
        @Result(column="DELETED_ROWS", property="DELETED_ROWS", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_COUNT", property="UPDATE_COUNT", jdbcType=JdbcType.BIGINT),
        @Result(column="FREE_EXTENTS", property="FREE_EXTENTS", jdbcType=JdbcType.BIGINT),
        @Result(column="TOTAL_EXTENTS", property="TOTAL_EXTENTS", jdbcType=JdbcType.BIGINT),
        @Result(column="EXTENT_SIZE", property="EXTENT_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="INITIAL_SIZE", property="INITIAL_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="MAXIMUM_SIZE", property="MAXIMUM_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="AUTOEXTEND_SIZE", property="AUTOEXTEND_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATION_TIME", property="CREATION_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_UPDATE_TIME", property="LAST_UPDATE_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_ACCESS_TIME", property="LAST_ACCESS_TIME", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RECOVER_TIME", property="RECOVER_TIME", jdbcType=JdbcType.BIGINT),
        @Result(column="TRANSACTION_COUNTER", property="TRANSACTION_COUNTER", jdbcType=JdbcType.BIGINT),
        @Result(column="VERSION", property="VERSION", jdbcType=JdbcType.BIGINT),
        @Result(column="ROW_FORMAT", property="ROW_FORMAT", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="STATUS", property="STATUS", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA", property="EXTRA", jdbcType=JdbcType.VARCHAR)
    })
    List<Files> selectAll();
}