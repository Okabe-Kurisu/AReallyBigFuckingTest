package com.mapper;

import com.model.InnodbBufferPage;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbBufferPageMapper {
    @Insert({
        "insert into INNODB_BUFFER_PAGE (POOL_ID, BLOCK_ID, ",
        "SPACE, PAGE_NUMBER, ",
        "PAGE_TYPE, FLUSH_TYPE, ",
        "FIX_COUNT, IS_HASHED, ",
        "NEWEST_MODIFICATION, OLDEST_MODIFICATION, ",
        "ACCESS_TIME, TABLE_NAME, ",
        "INDEX_NAME, NUMBER_RECORDS, ",
        "DATA_SIZE, COMPRESSED_SIZE, ",
        "PAGE_STATE, IO_FIX, ",
        "IS_OLD, FREE_PAGE_CLOCK)",
        "values (#{poolId,jdbcType=BIGINT}, #{blockId,jdbcType=BIGINT}, ",
        "#{space,jdbcType=BIGINT}, #{pageNumber,jdbcType=BIGINT}, ",
        "#{pageType,jdbcType=VARCHAR}, #{flushType,jdbcType=BIGINT}, ",
        "#{fixCount,jdbcType=BIGINT}, #{isHashed,jdbcType=VARCHAR}, ",
        "#{newestModification,jdbcType=BIGINT}, #{oldestModification,jdbcType=BIGINT}, ",
        "#{accessTime,jdbcType=BIGINT}, #{tableName,jdbcType=VARCHAR}, ",
        "#{indexName,jdbcType=VARCHAR}, #{numberRecords,jdbcType=BIGINT}, ",
        "#{dataSize,jdbcType=BIGINT}, #{compressedSize,jdbcType=BIGINT}, ",
        "#{pageState,jdbcType=VARCHAR}, #{ioFix,jdbcType=VARCHAR}, ",
        "#{isOld,jdbcType=VARCHAR}, #{freePageClock,jdbcType=BIGINT})"
    })
    int insert(InnodbBufferPage record);

    @Select({
        "select",
        "POOL_ID, BLOCK_ID, SPACE, PAGE_NUMBER, PAGE_TYPE, FLUSH_TYPE, FIX_COUNT, IS_HASHED, ",
        "NEWEST_MODIFICATION, OLDEST_MODIFICATION, ACCESS_TIME, TABLE_NAME, INDEX_NAME, ",
        "NUMBER_RECORDS, DATA_SIZE, COMPRESSED_SIZE, PAGE_STATE, IO_FIX, IS_OLD, FREE_PAGE_CLOCK",
        "from INNODB_BUFFER_PAGE"
    })
    @Results({
        @Result(column="POOL_ID", property="poolId", jdbcType=JdbcType.BIGINT),
        @Result(column="BLOCK_ID", property="blockId", jdbcType=JdbcType.BIGINT),
        @Result(column="SPACE", property="space", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGE_NUMBER", property="pageNumber", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGE_TYPE", property="pageType", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLUSH_TYPE", property="flushType", jdbcType=JdbcType.BIGINT),
        @Result(column="FIX_COUNT", property="fixCount", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_HASHED", property="isHashed", jdbcType=JdbcType.VARCHAR),
        @Result(column="NEWEST_MODIFICATION", property="newestModification", jdbcType=JdbcType.BIGINT),
        @Result(column="OLDEST_MODIFICATION", property="oldestModification", jdbcType=JdbcType.BIGINT),
        @Result(column="ACCESS_TIME", property="accessTime", jdbcType=JdbcType.BIGINT),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_NAME", property="indexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="NUMBER_RECORDS", property="numberRecords", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_SIZE", property="dataSize", jdbcType=JdbcType.BIGINT),
        @Result(column="COMPRESSED_SIZE", property="compressedSize", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGE_STATE", property="pageState", jdbcType=JdbcType.VARCHAR),
        @Result(column="IO_FIX", property="ioFix", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_OLD", property="isOld", jdbcType=JdbcType.VARCHAR),
        @Result(column="FREE_PAGE_CLOCK", property="freePageClock", jdbcType=JdbcType.BIGINT)
    })
    List<InnodbBufferPage> selectAll();
}