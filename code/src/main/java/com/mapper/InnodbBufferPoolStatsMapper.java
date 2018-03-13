package com.mapper;

import com.model.InnodbBufferPoolStats;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbBufferPoolStatsMapper {
    @Insert({
        "insert into INNODB_BUFFER_POOL_STATS (POOL_ID, POOL_SIZE, ",
        "FREE_BUFFERS, DATABASE_PAGES, ",
        "OLD_DATABASE_PAGES, MODIFIED_DATABASE_PAGES, ",
        "PENDING_DECOMPRESS, PENDING_READS, ",
        "PENDING_FLUSH_LRU, PENDING_FLUSH_LIST, ",
        "PAGES_MADE_YOUNG, PAGES_NOT_MADE_YOUNG, ",
        "PAGES_MADE_YOUNG_RATE, PAGES_MADE_NOT_YOUNG_RATE, ",
        "NUMBER_PAGES_READ, NUMBER_PAGES_CREATED, ",
        "NUMBER_PAGES_WRITTEN, PAGES_READ_RATE, ",
        "PAGES_CREATE_RATE, PAGES_WRITTEN_RATE, ",
        "NUMBER_PAGES_GET, HIT_RATE, ",
        "YOUNG_MAKE_PER_THOUSAND_GETS, NOT_YOUNG_MAKE_PER_THOUSAND_GETS, ",
        "NUMBER_PAGES_READ_AHEAD, NUMBER_READ_AHEAD_EVICTED, ",
        "READ_AHEAD_RATE, READ_AHEAD_EVICTED_RATE, ",
        "LRU_IO_TOTAL, LRU_IO_CURRENT, ",
        "UNCOMPRESS_TOTAL, UNCOMPRESS_CURRENT)",
        "values (#{poolId,jdbcType=BIGINT}, #{poolSize,jdbcType=BIGINT}, ",
        "#{freeBuffers,jdbcType=BIGINT}, #{databasePages,jdbcType=BIGINT}, ",
        "#{oldDatabasePages,jdbcType=BIGINT}, #{modifiedDatabasePages,jdbcType=BIGINT}, ",
        "#{pendingDecompress,jdbcType=BIGINT}, #{pendingReads,jdbcType=BIGINT}, ",
        "#{pendingFlushLru,jdbcType=BIGINT}, #{pendingFlushList,jdbcType=BIGINT}, ",
        "#{pagesMadeYoung,jdbcType=BIGINT}, #{pagesNotMadeYoung,jdbcType=BIGINT}, ",
        "#{pagesMadeYoungRate,jdbcType=DOUBLE}, #{pagesMadeNotYoungRate,jdbcType=DOUBLE}, ",
        "#{numberPagesRead,jdbcType=BIGINT}, #{numberPagesCreated,jdbcType=BIGINT}, ",
        "#{numberPagesWritten,jdbcType=BIGINT}, #{pagesReadRate,jdbcType=DOUBLE}, ",
        "#{pagesCreateRate,jdbcType=DOUBLE}, #{pagesWrittenRate,jdbcType=DOUBLE}, ",
        "#{numberPagesGet,jdbcType=BIGINT}, #{hitRate,jdbcType=BIGINT}, ",
        "#{youngMakePerThousandGets,jdbcType=BIGINT}, #{notYoungMakePerThousandGets,jdbcType=BIGINT}, ",
        "#{numberPagesReadAhead,jdbcType=BIGINT}, #{numberReadAheadEvicted,jdbcType=BIGINT}, ",
        "#{readAheadRate,jdbcType=DOUBLE}, #{readAheadEvictedRate,jdbcType=DOUBLE}, ",
        "#{lruIoTotal,jdbcType=BIGINT}, #{lruIoCurrent,jdbcType=BIGINT}, ",
        "#{uncompressTotal,jdbcType=BIGINT}, #{uncompressCurrent,jdbcType=BIGINT})"
    })
    int insert(InnodbBufferPoolStats record);

    @Select({
        "select",
        "POOL_ID, POOL_SIZE, FREE_BUFFERS, DATABASE_PAGES, OLD_DATABASE_PAGES, MODIFIED_DATABASE_PAGES, ",
        "PENDING_DECOMPRESS, PENDING_READS, PENDING_FLUSH_LRU, PENDING_FLUSH_LIST, PAGES_MADE_YOUNG, ",
        "PAGES_NOT_MADE_YOUNG, PAGES_MADE_YOUNG_RATE, PAGES_MADE_NOT_YOUNG_RATE, NUMBER_PAGES_READ, ",
        "NUMBER_PAGES_CREATED, NUMBER_PAGES_WRITTEN, PAGES_READ_RATE, PAGES_CREATE_RATE, ",
        "PAGES_WRITTEN_RATE, NUMBER_PAGES_GET, HIT_RATE, YOUNG_MAKE_PER_THOUSAND_GETS, ",
        "NOT_YOUNG_MAKE_PER_THOUSAND_GETS, NUMBER_PAGES_READ_AHEAD, NUMBER_READ_AHEAD_EVICTED, ",
        "READ_AHEAD_RATE, READ_AHEAD_EVICTED_RATE, LRU_IO_TOTAL, LRU_IO_CURRENT, UNCOMPRESS_TOTAL, ",
        "UNCOMPRESS_CURRENT",
        "from INNODB_BUFFER_POOL_STATS"
    })
    @Results({
        @Result(column="POOL_ID", property="poolId", jdbcType=JdbcType.BIGINT),
        @Result(column="POOL_SIZE", property="poolSize", jdbcType=JdbcType.BIGINT),
        @Result(column="FREE_BUFFERS", property="freeBuffers", jdbcType=JdbcType.BIGINT),
        @Result(column="DATABASE_PAGES", property="databasePages", jdbcType=JdbcType.BIGINT),
        @Result(column="OLD_DATABASE_PAGES", property="oldDatabasePages", jdbcType=JdbcType.BIGINT),
        @Result(column="MODIFIED_DATABASE_PAGES", property="modifiedDatabasePages", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_DECOMPRESS", property="pendingDecompress", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_READS", property="pendingReads", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_FLUSH_LRU", property="pendingFlushLru", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_FLUSH_LIST", property="pendingFlushList", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_MADE_YOUNG", property="pagesMadeYoung", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_NOT_MADE_YOUNG", property="pagesNotMadeYoung", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_MADE_YOUNG_RATE", property="pagesMadeYoungRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="PAGES_MADE_NOT_YOUNG_RATE", property="pagesMadeNotYoungRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="NUMBER_PAGES_READ", property="numberPagesRead", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_PAGES_CREATED", property="numberPagesCreated", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_PAGES_WRITTEN", property="numberPagesWritten", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_READ_RATE", property="pagesReadRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="PAGES_CREATE_RATE", property="pagesCreateRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="PAGES_WRITTEN_RATE", property="pagesWrittenRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="NUMBER_PAGES_GET", property="numberPagesGet", jdbcType=JdbcType.BIGINT),
        @Result(column="HIT_RATE", property="hitRate", jdbcType=JdbcType.BIGINT),
        @Result(column="YOUNG_MAKE_PER_THOUSAND_GETS", property="youngMakePerThousandGets", jdbcType=JdbcType.BIGINT),
        @Result(column="NOT_YOUNG_MAKE_PER_THOUSAND_GETS", property="notYoungMakePerThousandGets", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_PAGES_READ_AHEAD", property="numberPagesReadAhead", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_READ_AHEAD_EVICTED", property="numberReadAheadEvicted", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_AHEAD_RATE", property="readAheadRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="READ_AHEAD_EVICTED_RATE", property="readAheadEvictedRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="LRU_IO_TOTAL", property="lruIoTotal", jdbcType=JdbcType.BIGINT),
        @Result(column="LRU_IO_CURRENT", property="lruIoCurrent", jdbcType=JdbcType.BIGINT),
        @Result(column="UNCOMPRESS_TOTAL", property="uncompressTotal", jdbcType=JdbcType.BIGINT),
        @Result(column="UNCOMPRESS_CURRENT", property="uncompressCurrent", jdbcType=JdbcType.BIGINT)
    })
    List<InnodbBufferPoolStats> selectAll();
}