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
        "values (#{POOL_ID,jdbcType=BIGINT}, #{POOL_SIZE,jdbcType=BIGINT}, ",
        "#{FREE_BUFFERS,jdbcType=BIGINT}, #{DATABASE_PAGES,jdbcType=BIGINT}, ",
        "#{OLD_DATABASE_PAGES,jdbcType=BIGINT}, #{MODIFIED_DATABASE_PAGES,jdbcType=BIGINT}, ",
        "#{PENDING_DECOMPRESS,jdbcType=BIGINT}, #{PENDING_READS,jdbcType=BIGINT}, ",
        "#{PENDING_FLUSH_LRU,jdbcType=BIGINT}, #{PENDING_FLUSH_LIST,jdbcType=BIGINT}, ",
        "#{PAGES_MADE_YOUNG,jdbcType=BIGINT}, #{PAGES_NOT_MADE_YOUNG,jdbcType=BIGINT}, ",
        "#{PAGES_MADE_YOUNG_RATE,jdbcType=DOUBLE}, #{PAGES_MADE_NOT_YOUNG_RATE,jdbcType=DOUBLE}, ",
        "#{NUMBER_PAGES_READ,jdbcType=BIGINT}, #{NUMBER_PAGES_CREATED,jdbcType=BIGINT}, ",
        "#{NUMBER_PAGES_WRITTEN,jdbcType=BIGINT}, #{PAGES_READ_RATE,jdbcType=DOUBLE}, ",
        "#{PAGES_CREATE_RATE,jdbcType=DOUBLE}, #{PAGES_WRITTEN_RATE,jdbcType=DOUBLE}, ",
        "#{NUMBER_PAGES_GET,jdbcType=BIGINT}, #{HIT_RATE,jdbcType=BIGINT}, ",
        "#{YOUNG_MAKE_PER_THOUSAND_GETS,jdbcType=BIGINT}, #{NOT_YOUNG_MAKE_PER_THOUSAND_GETS,jdbcType=BIGINT}, ",
        "#{NUMBER_PAGES_READ_AHEAD,jdbcType=BIGINT}, #{NUMBER_READ_AHEAD_EVICTED,jdbcType=BIGINT}, ",
        "#{READ_AHEAD_RATE,jdbcType=DOUBLE}, #{READ_AHEAD_EVICTED_RATE,jdbcType=DOUBLE}, ",
        "#{LRU_IO_TOTAL,jdbcType=BIGINT}, #{LRU_IO_CURRENT,jdbcType=BIGINT}, ",
        "#{UNCOMPRESS_TOTAL,jdbcType=BIGINT}, #{UNCOMPRESS_CURRENT,jdbcType=BIGINT})"
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
        @Result(column="POOL_ID", property="POOL_ID", jdbcType=JdbcType.BIGINT),
        @Result(column="POOL_SIZE", property="POOL_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="FREE_BUFFERS", property="FREE_BUFFERS", jdbcType=JdbcType.BIGINT),
        @Result(column="DATABASE_PAGES", property="DATABASE_PAGES", jdbcType=JdbcType.BIGINT),
        @Result(column="OLD_DATABASE_PAGES", property="OLD_DATABASE_PAGES", jdbcType=JdbcType.BIGINT),
        @Result(column="MODIFIED_DATABASE_PAGES", property="MODIFIED_DATABASE_PAGES", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_DECOMPRESS", property="PENDING_DECOMPRESS", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_READS", property="PENDING_READS", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_FLUSH_LRU", property="PENDING_FLUSH_LRU", jdbcType=JdbcType.BIGINT),
        @Result(column="PENDING_FLUSH_LIST", property="PENDING_FLUSH_LIST", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_MADE_YOUNG", property="PAGES_MADE_YOUNG", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_NOT_MADE_YOUNG", property="PAGES_NOT_MADE_YOUNG", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_MADE_YOUNG_RATE", property="PAGES_MADE_YOUNG_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="PAGES_MADE_NOT_YOUNG_RATE", property="PAGES_MADE_NOT_YOUNG_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="NUMBER_PAGES_READ", property="NUMBER_PAGES_READ", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_PAGES_CREATED", property="NUMBER_PAGES_CREATED", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_PAGES_WRITTEN", property="NUMBER_PAGES_WRITTEN", jdbcType=JdbcType.BIGINT),
        @Result(column="PAGES_READ_RATE", property="PAGES_READ_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="PAGES_CREATE_RATE", property="PAGES_CREATE_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="PAGES_WRITTEN_RATE", property="PAGES_WRITTEN_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="NUMBER_PAGES_GET", property="NUMBER_PAGES_GET", jdbcType=JdbcType.BIGINT),
        @Result(column="HIT_RATE", property="HIT_RATE", jdbcType=JdbcType.BIGINT),
        @Result(column="YOUNG_MAKE_PER_THOUSAND_GETS", property="YOUNG_MAKE_PER_THOUSAND_GETS", jdbcType=JdbcType.BIGINT),
        @Result(column="NOT_YOUNG_MAKE_PER_THOUSAND_GETS", property="NOT_YOUNG_MAKE_PER_THOUSAND_GETS", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_PAGES_READ_AHEAD", property="NUMBER_PAGES_READ_AHEAD", jdbcType=JdbcType.BIGINT),
        @Result(column="NUMBER_READ_AHEAD_EVICTED", property="NUMBER_READ_AHEAD_EVICTED", jdbcType=JdbcType.BIGINT),
        @Result(column="READ_AHEAD_RATE", property="READ_AHEAD_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="READ_AHEAD_EVICTED_RATE", property="READ_AHEAD_EVICTED_RATE", jdbcType=JdbcType.DOUBLE),
        @Result(column="LRU_IO_TOTAL", property="LRU_IO_TOTAL", jdbcType=JdbcType.BIGINT),
        @Result(column="LRU_IO_CURRENT", property="LRU_IO_CURRENT", jdbcType=JdbcType.BIGINT),
        @Result(column="UNCOMPRESS_TOTAL", property="UNCOMPRESS_TOTAL", jdbcType=JdbcType.BIGINT),
        @Result(column="UNCOMPRESS_CURRENT", property="UNCOMPRESS_CURRENT", jdbcType=JdbcType.BIGINT)
    })
    List<InnodbBufferPoolStats> selectAll();
}