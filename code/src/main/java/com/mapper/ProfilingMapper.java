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
        "values (#{queryId,jdbcType=INTEGER}, #{seq,jdbcType=INTEGER}, ",
        "#{state,jdbcType=VARCHAR}, #{duration,jdbcType=DECIMAL}, ",
        "#{cpuUser,jdbcType=DECIMAL}, #{cpuSystem,jdbcType=DECIMAL}, ",
        "#{contextVoluntary,jdbcType=INTEGER}, #{contextInvoluntary,jdbcType=INTEGER}, ",
        "#{blockOpsIn,jdbcType=INTEGER}, #{blockOpsOut,jdbcType=INTEGER}, ",
        "#{messagesSent,jdbcType=INTEGER}, #{messagesReceived,jdbcType=INTEGER}, ",
        "#{pageFaultsMajor,jdbcType=INTEGER}, #{pageFaultsMinor,jdbcType=INTEGER}, ",
        "#{swaps,jdbcType=INTEGER}, #{sourceFunction,jdbcType=VARCHAR}, ",
        "#{sourceFile,jdbcType=VARCHAR}, #{sourceLine,jdbcType=INTEGER})"
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
        @Result(column="QUERY_ID", property="queryId", jdbcType=JdbcType.INTEGER),
        @Result(column="SEQ", property="seq", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="DURATION", property="duration", jdbcType=JdbcType.DECIMAL),
        @Result(column="CPU_USER", property="cpuUser", jdbcType=JdbcType.DECIMAL),
        @Result(column="CPU_SYSTEM", property="cpuSystem", jdbcType=JdbcType.DECIMAL),
        @Result(column="CONTEXT_VOLUNTARY", property="contextVoluntary", jdbcType=JdbcType.INTEGER),
        @Result(column="CONTEXT_INVOLUNTARY", property="contextInvoluntary", jdbcType=JdbcType.INTEGER),
        @Result(column="BLOCK_OPS_IN", property="blockOpsIn", jdbcType=JdbcType.INTEGER),
        @Result(column="BLOCK_OPS_OUT", property="blockOpsOut", jdbcType=JdbcType.INTEGER),
        @Result(column="MESSAGES_SENT", property="messagesSent", jdbcType=JdbcType.INTEGER),
        @Result(column="MESSAGES_RECEIVED", property="messagesReceived", jdbcType=JdbcType.INTEGER),
        @Result(column="PAGE_FAULTS_MAJOR", property="pageFaultsMajor", jdbcType=JdbcType.INTEGER),
        @Result(column="PAGE_FAULTS_MINOR", property="pageFaultsMinor", jdbcType=JdbcType.INTEGER),
        @Result(column="SWAPS", property="swaps", jdbcType=JdbcType.INTEGER),
        @Result(column="SOURCE_FUNCTION", property="sourceFunction", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_FILE", property="sourceFile", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_LINE", property="sourceLine", jdbcType=JdbcType.INTEGER)
    })
    List<Profiling> selectAll();
}