package com.mapper;

import com.model.InnodbBufferPageLru;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbBufferPageLruMapper {
    @Insert({
        "insert into INNODB_BUFFER_PAGE_LRU (POOL_ID, LRU_POSITION, ",
        "SPACE, PAGE_NUMBER, ",
        "PAGE_TYPE, FLUSH_TYPE, ",
        "FIX_COUNT, IS_HASHED, ",
        "NEWEST_MODIFICATION, OLDEST_MODIFICATION, ",
        "ACCESS_TIME, TABLE_NAME, ",
        "INDEX_NAME, NUMBER_RECORDS, ",
        "DATA_SIZE, COMPRESSED_SIZE, ",
        "COMPRESSED, IO_FIX, ",
        "IS_OLD, FREE_PAGE_CLOCK)",
        "values (#{POOL_ID,jdbcType=BIGINT}, #{LRU_POSITION,jdbcType=BIGINT}, ",
        "#{SPACE,jdbcType=BIGINT}, #{PAGE_NUMBER,jdbcType=BIGINT}, ",
        "#{PAGE_TYPE,jdbcType=VARCHAR}, #{FLUSH_TYPE,jdbcType=BIGINT}, ",
        "#{FIX_COUNT,jdbcType=BIGINT}, #{IS_HASHED,jdbcType=VARCHAR}, ",
        "#{NEWEST_MODIFICATION,jdbcType=BIGINT}, #{OLDEST_MODIFICATION,jdbcType=BIGINT}, ",
        "#{ACCESS_TIME,jdbcType=BIGINT}, #{TABLE_NAME,jdbcType=VARCHAR}, ",
        "#{INDEX_NAME,jdbcType=VARCHAR}, #{NUMBER_RECORDS,jdbcType=BIGINT}, ",
        "#{DATA_SIZE,jdbcType=BIGINT}, #{COMPRESSED_SIZE,jdbcType=BIGINT}, ",
        "#{COMPRESSED,jdbcType=VARCHAR}, #{IO_FIX,jdbcType=VARCHAR}, ",
        "#{IS_OLD,jdbcType=VARCHAR}, #{FREE_PAGE_CLOCK,jdbcType=BIGINT})"
    })
    int insert(InnodbBufferPageLru record);

    @Select({
        "select",
        "POOL_ID, LRU_POSITION, SPACE, PAGE_NUMBER, PAGE_TYPE, FLUSH_TYPE, FIX_COUNT, ",
        "IS_HASHED, NEWEST_MODIFICATION, OLDEST_MODIFICATION, ACCESS_TIME, TABLE_NAME, ",
        "INDEX_NAME, NUMBER_RECORDS, DATA_SIZE, COMPRESSED_SIZE, COMPRESSED, IO_FIX, ",
        "IS_OLD, FREE_PAGE_CLOCK",
        "from INNODB_BUFFER_PAGE_LRU"
    })
    @Results({
        @Result(column="POOL_ID", property="POOL_ID", jdbcType=JdbcType.BIGINT),
        @Result(column="LRU_POSITION", property="LRU_POSITION", jdbcType=JdbcType.BIGINT),
        @Result(column="SPACE", property="SPACE", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGE_NUMBER", property="PAGE_NUMBER", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGE_TYPE", property="PAGE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLUSH_TYPE", property="FLUSH_TYPE", jdbcType=JdbcType.BIGINT),
        @Result(column="FIX_COUNT", property="FIX_COUNT", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_HASHED", property="IS_HASHED", jdbcType=JdbcType.VARCHAR),
        @Result(column="NEWEST_MODIFICATION", property="NEWEST_MODIFICATION", jdbcType=JdbcType.BIGINT),
        @Result(column="OLDEST_MODIFICATION", property="OLDEST_MODIFICATION", jdbcType=JdbcType.BIGINT),
        @Result(column="ACCESS_TIME", property="ACCESS_TIME", jdbcType=JdbcType.BIGINT),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="INDEX_NAME", property="INDEX_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="NUMBER_RECORDS", property="NUMBER_RECORDS", jdbcType=JdbcType.BIGINT),
        @Result(column="DATA_SIZE", property="DATA_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="COMPRESSED_SIZE", property="COMPRESSED_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="COMPRESSED", property="COMPRESSED", jdbcType=JdbcType.VARCHAR),
        @Result(column="IO_FIX", property="IO_FIX", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_OLD", property="IS_OLD", jdbcType=JdbcType.VARCHAR),
        @Result(column="FREE_PAGE_CLOCK", property="FREE_PAGE_CLOCK", jdbcType=JdbcType.BIGINT)
    })
    List<InnodbBufferPageLru> selectAll();
}