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
        "values (#{trx_id,jdbcType=VARCHAR}, #{trx_state,jdbcType=VARCHAR}, ",
        "#{trx_started,jdbcType=TIMESTAMP}, #{trx_requested_lock_id,jdbcType=VARCHAR}, ",
        "#{trx_wait_started,jdbcType=TIMESTAMP}, #{trx_weight,jdbcType=BIGINT}, ",
        "#{trx_mysql_thread_id,jdbcType=BIGINT}, #{trx_query,jdbcType=VARCHAR}, ",
        "#{trx_operation_state,jdbcType=VARCHAR}, #{trx_tables_in_use,jdbcType=BIGINT}, ",
        "#{trx_tables_locked,jdbcType=BIGINT}, #{trx_lock_structs,jdbcType=BIGINT}, ",
        "#{trx_lock_memory_bytes,jdbcType=BIGINT}, #{trx_rows_locked,jdbcType=BIGINT}, ",
        "#{trx_rows_modified,jdbcType=BIGINT}, #{trx_concurrency_tickets,jdbcType=BIGINT}, ",
        "#{trx_isolation_level,jdbcType=VARCHAR}, #{trx_unique_checks,jdbcType=INTEGER}, ",
        "#{trx_foreign_key_checks,jdbcType=INTEGER}, #{trx_last_foreign_key_error,jdbcType=VARCHAR}, ",
        "#{trx_adaptive_hash_latched,jdbcType=INTEGER}, #{trx_adaptive_hash_timeout,jdbcType=BIGINT})"
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
        @Result(column="trx_id", property="trx_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_state", property="trx_state", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_started", property="trx_started", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trx_requested_lock_id", property="trx_requested_lock_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_wait_started", property="trx_wait_started", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="trx_weight", property="trx_weight", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_mysql_thread_id", property="trx_mysql_thread_id", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_query", property="trx_query", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_operation_state", property="trx_operation_state", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_tables_in_use", property="trx_tables_in_use", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_tables_locked", property="trx_tables_locked", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_lock_structs", property="trx_lock_structs", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_lock_memory_bytes", property="trx_lock_memory_bytes", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_rows_locked", property="trx_rows_locked", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_rows_modified", property="trx_rows_modified", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_concurrency_tickets", property="trx_concurrency_tickets", jdbcType=JdbcType.BIGINT),
        @Result(column="trx_isolation_level", property="trx_isolation_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_unique_checks", property="trx_unique_checks", jdbcType=JdbcType.INTEGER),
        @Result(column="trx_foreign_key_checks", property="trx_foreign_key_checks", jdbcType=JdbcType.INTEGER),
        @Result(column="trx_last_foreign_key_error", property="trx_last_foreign_key_error", jdbcType=JdbcType.VARCHAR),
        @Result(column="trx_adaptive_hash_latched", property="trx_adaptive_hash_latched", jdbcType=JdbcType.INTEGER),
        @Result(column="trx_adaptive_hash_timeout", property="trx_adaptive_hash_timeout", jdbcType=JdbcType.BIGINT)
    })
    List<InnodbTrx> selectAll();
}