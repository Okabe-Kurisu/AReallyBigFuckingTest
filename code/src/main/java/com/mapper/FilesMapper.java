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
        "values (#{fileId,jdbcType=BIGINT}, #{fileName,jdbcType=VARCHAR}, ",
        "#{fileType,jdbcType=VARCHAR}, #{tablespaceName,jdbcType=VARCHAR}, ",
        "#{tableCatalog,jdbcType=VARCHAR}, #{tableSchema,jdbcType=VARCHAR}, ",
        "#{tableName,jdbcType=VARCHAR}, #{logfileGroupName,jdbcType=VARCHAR}, ",
        "#{logfileGroupNumber,jdbcType=BIGINT}, #{engine,jdbcType=VARCHAR}, ",
        "#{fulltextKeys,jdbcType=VARCHAR}, #{deletedRows,jdbcType=BIGINT}, ",
        "#{updateCount,jdbcType=BIGINT}, #{freeExtents,jdbcType=BIGINT}, ",
        "#{totalExtents,jdbcType=BIGINT}, #{extentSize,jdbcType=BIGINT}, ",
        "#{initialSize,jdbcType=BIGINT}, #{maximumSize,jdbcType=BIGINT}, ",
        "#{autoextendSize,jdbcType=BIGINT}, #{creationTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP}, #{lastAccessTime,jdbcType=TIMESTAMP}, ",
        "#{recoverTime,jdbcType=BIGINT}, #{transactionCounter,jdbcType=BIGINT}, ",
        "#{version,jdbcType=BIGINT}, #{rowFormat,jdbcType=VARCHAR}, ",
        "#{tableRows,jdbcType=BIGINT}, #{avgRowLength,jdbcType=BIGINT}, ",
        "#{dataLength,jdbcType=BIGINT}, #{maxDataLength,jdbcType=BIGINT}, ",
        "#{indexLength,jdbcType=BIGINT}, #{dataFree,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{checkTime,jdbcType=TIMESTAMP}, #{checksum,jdbcType=BIGINT}, ",
        "#{status,jdbcType=VARCHAR}, #{extra,jdbcType=VARCHAR})"
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
        @Result(column="FILE_ID", property="fileId", jdbcType=JdbcType.BIGINT),
        @Result(column="FILE_NAME", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="FILE_TYPE", property="fileType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLESPACE_NAME", property="tablespaceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOGFILE_GROUP_NAME", property="logfileGroupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOGFILE_GROUP_NUMBER", property="logfileGroupNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="ENGINE", property="engine", jdbcType=JdbcType.VARCHAR),
        @Result(column="FULLTEXT_KEYS", property="fulltextKeys", jdbcType=JdbcType.VARCHAR),
        @Result(column="DELETED_ROWS", property="deletedRows", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_COUNT", property="updateCount", jdbcType=JdbcType.BIGINT),
        @Result(column="FREE_EXTENTS", property="freeExtents", jdbcType=JdbcType.BIGINT),
        @Result(column="TOTAL_EXTENTS", property="totalExtents", jdbcType=JdbcType.BIGINT),
        @Result(column="EXTENT_SIZE", property="extentSize", jdbcType=JdbcType.BIGINT),
        @Result(column="INITIAL_SIZE", property="initialSize", jdbcType=JdbcType.BIGINT),
        @Result(column="MAXIMUM_SIZE", property="maximumSize", jdbcType=JdbcType.BIGINT),
        @Result(column="AUTOEXTEND_SIZE", property="autoextendSize", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATION_TIME", property="creationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_UPDATE_TIME", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_ACCESS_TIME", property="lastAccessTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RECOVER_TIME", property="recoverTime", jdbcType=JdbcType.BIGINT),
        @Result(column="TRANSACTION_COUNTER", property="transactionCounter", jdbcType=JdbcType.BIGINT),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="ROW_FORMAT", property="rowFormat", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_ROWS", property="tableRows", jdbcType=JdbcType.BIGINT),
        @Result(column="AVG_ROW_LENGTH", property="avgRowLength", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_LENGTH", property="dataLength", jdbcType=JdbcType.BIGINT),
        @Result(column="MAX_DATA_LENGTH", property="maxDataLength", jdbcType=JdbcType.BIGINT),
        @Result(column="INDEX_LENGTH", property="indexLength", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_FREE", property="dataFree", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CHECK_TIME", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CHECKSUM", property="checksum", jdbcType=JdbcType.BIGINT),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA", property="extra", jdbcType=JdbcType.VARCHAR)
    })
    List<Files> selectAll();
}