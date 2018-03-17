package com.mapper;

import com.model.Profiling;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ProfilingMapper {
    @Insert({
        "insert into PROFILING (QUERY_ID, SEQ, ",
        "STATE, DURATION, ",
        "CPU_USER, CPU_SYSTEM, ",
        "CONTEXT_VOLUNTARY, CONTEXT_INVOLUNTARY, ",
        "BLOCK_OPS_IN, BLOCK_OPS_OUT, ",
        "MESSAGES_SENT, MESSAGES_RECEIVED, ",
        "PAGE_FAULTS_MAJOR, PAGE_FAULTS_MINOR, ",
        "SWAPS, SOURCE_FUNCTION, ",
        "SOURCE_FILE, SOURCE_LINE)",
        "values (#{QUERY_ID,jdbcType=INTEGER}, #{SEQ,jdbcType=INTEGER}, ",
        "#{STATE,jdbcType=VARCHAR}, #{DURATION,jdbcType=DECIMAL}, ",
        "#{CPU_USER,jdbcType=DECIMAL}, #{CPU_SYSTEM,jdbcType=DECIMAL}, ",
        "#{CONTEXT_VOLUNTARY,jdbcType=INTEGER}, #{CONTEXT_INVOLUNTARY,jdbcType=INTEGER}, ",
        "#{BLOCK_OPS_IN,jdbcType=INTEGER}, #{BLOCK_OPS_OUT,jdbcType=INTEGER}, ",
        "#{MESSAGES_SENT,jdbcType=INTEGER}, #{MESSAGES_RECEIVED,jdbcType=INTEGER}, ",
        "#{PAGE_FAULTS_MAJOR,jdbcType=INTEGER}, #{PAGE_FAULTS_MINOR,jdbcType=INTEGER}, ",
        "#{SWAPS,jdbcType=INTEGER}, #{SOURCE_FUNCTION,jdbcType=VARCHAR}, ",
        "#{SOURCE_FILE,jdbcType=VARCHAR}, #{SOURCE_LINE,jdbcType=INTEGER})"
    })
    int insert(Profiling record);

    @Select({
        "select",
        "QUERY_ID, SEQ, STATE, DURATION, CPU_USER, CPU_SYSTEM, CONTEXT_VOLUNTARY, CONTEXT_INVOLUNTARY, ",
        "BLOCK_OPS_IN, BLOCK_OPS_OUT, MESSAGES_SENT, MESSAGES_RECEIVED, PAGE_FAULTS_MAJOR, ",
        "PAGE_FAULTS_MINOR, SWAPS, SOURCE_FUNCTION, SOURCE_FILE, SOURCE_LINE",
        "from PROFILING"
    })
    @Results({
        @Result(column="QUERY_ID", property="QUERY_ID", jdbcType=JdbcType.INTEGER),
        @Result(column="SEQ", property="SEQ", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="STATE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DURATION", property="DURATION", jdbcType=JdbcType.DECIMAL),
        @Result(column="CPU_USER", property="CPU_USER", jdbcType=JdbcType.DECIMAL),
        @Result(column="CPU_SYSTEM", property="CPU_SYSTEM", jdbcType=JdbcType.DECIMAL),
        @Result(column="CONTEXT_VOLUNTARY", property="CONTEXT_VOLUNTARY", jdbcType=JdbcType.INTEGER),
        @Result(column="CONTEXT_INVOLUNTARY", property="CONTEXT_INVOLUNTARY", jdbcType=JdbcType.INTEGER),
        @Result(column="BLOCK_OPS_IN", property="BLOCK_OPS_IN", jdbcType=JdbcType.INTEGER),
        @Result(column="BLOCK_OPS_OUT", property="BLOCK_OPS_OUT", jdbcType=JdbcType.INTEGER),
        @Result(column="MESSAGES_SENT", property="MESSAGES_SENT", jdbcType=JdbcType.INTEGER),
        @Result(column="MESSAGES_RECEIVED", property="MESSAGES_RECEIVED", jdbcType=JdbcType.INTEGER),
        @Result(column="PAGE_FAULTS_MAJOR", property="PAGE_FAULTS_MAJOR", jdbcType=JdbcType.INTEGER),
        @Result(column="PAGE_FAULTS_MINOR", property="PAGE_FAULTS_MINOR", jdbcType=JdbcType.INTEGER),
        @Result(column="SWAPS", property="SWAPS", jdbcType=JdbcType.INTEGER),
        @Result(column="SOURCE_FUNCTION", property="SOURCE_FUNCTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_FILE", property="SOURCE_FILE", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_LINE", property="SOURCE_LINE", jdbcType=JdbcType.INTEGER)
    })
    List<Profiling> selectAll();
}