package com.mapper;

import com.model.InnodbTrx;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbTrxMapper {
    @Insert({
        "insert into INNODB_TRX (trx_id, trx_state, ",
        "trx_started, trx_requested_lock_id, ",
        "trx_wait_started, trx_weight, ",
        "trx_mysql_thread_id, trx_query, ",
        "trx_operation_state, trx_tables_in_use, ",
        "trx_tables_locked, trx_lock_structs, ",
        "trx_lock_memory_bytes, trx_rows_locked, ",
        "trx_rows_modified, trx_concurrency_tickets, ",
        "trx_isolation_level, trx_unique_checks, ",
        "trx_foreign_key_checks, trx_last_foreign_key_error, ",
        "trx_adaptive_hash_latched, trx_adaptive_hash_timeout)",
        "values (#{trxId,jdbcType=VARCHAR}, #{trxState,jdbcType=VARCHAR}, ",
        "#{trxStarted,jdbcType=TIMESTAMP}, #{trxRequestedLockId,jdbcType=VARCHAR}, ",
        "#{trxWaitStarted,jdbcType=TIMESTAMP}, #{trxWeight,jdbcType=BIGINT}, ",
        "#{trxMysqlThreadId,jdbcType=BIGINT}, #{trxQuery,jdbcType=VARCHAR}, ",
        "#{trxOperationState,jdbcType=VARCHAR}, #{trxTablesInUse,jdbcType=BIGINT}, ",
        "#{trxTablesLocked,jdbcType=BIGINT}, #{trxLockStructs,jdbcType=BIGINT}, ",
        "#{trxLockMemoryBytes,jdbcType=BIGINT}, #{trxRowsLocked,jdbcType=BIGINT}, ",
        "#{trxRowsModified,jdbcType=BIGINT}, #{trxConcurrencyTickets,jdbcType=BIGINT}, ",
        "#{trxIsolationLevel,jdbcType=VARCHAR}, #{trxUniqueChecks,jdbcType=INTEGER}, ",
        "#{trxForeignKeyChecks,jdbcType=INTEGER}, #{trxLastForeignKeyError,jdbcType=VARCHAR}, ",
        "#{trxAdaptiveHashLatched,jdbcType=INTEGER}, #{trxAdaptiveHashTimeout,jdbcType=BIGINT})"
    })
    int insert(InnodbTrx record);

    @Select({
        "select",
        "trx_id, trx_state, trx_started, trx_requested_lock_id, trx_wait_started, trx_weight, ",
        "trx_mysql_thread_id, trx_query, trx_operation_state, trx_tables_in_use, trx_tables_locked, ",
        "trx_lock_structs, trx_lock_memory_bytes, trx_rows_locked, trx_rows_modified, ",
        "trx_concurrency_tickets, trx_isolation_level, trx_unique_checks, trx_foreign_key_checks, ",
        "trx_last_foreign_key_error, trx_adaptive_hash_latched, trx_adaptive_hash_timeout",
        "from INNODB_TRX"
    })
    @Results({
        @Result(column="trx_id", property="trxId", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_state", property="trxState", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_started", property="trxStarted", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trx_requested_lock_id", property="trxRequestedLockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_wait_started", property="trxWaitStarted", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trx_weight", property="trxWeight", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_mysql_thread_id", property="trxMysqlThreadId", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_query", property="trxQuery", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_operation_state", property="trxOperationState", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_tables_in_use", property="trxTablesInUse", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_tables_locked", property="trxTablesLocked", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_lock_structs", property="trxLockStructs", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_lock_memory_bytes", property="trxLockMemoryBytes", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_rows_locked", property="trxRowsLocked", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_rows_modified", property="trxRowsModified", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_concurrency_tickets", property="trxConcurrencyTickets", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_isolation_level", property="trxIsolationLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_unique_checks", property="trxUniqueChecks", jdbcType=JdbcType.INTEGER),
        @Result(column="trx_foreign_key_checks", property="trxForeignKeyChecks", jdbcType=JdbcType.INTEGER),
        @Result(column="trx_last_foreign_key_error", property="trxLastForeignKeyError", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_adaptive_hash_latched", property="trxAdaptiveHashLatched", jdbcType=JdbcType.INTEGER),
        @Result(column="trx_adaptive_hash_timeout", property="trxAdaptiveHashTimeout", jdbcType=JdbcType.BIGINT)
    })
    List<InnodbTrx> selectAll();
}