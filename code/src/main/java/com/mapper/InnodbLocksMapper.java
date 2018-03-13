package com.mapper;

import com.model.InnodbLocks;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbLocksMapper {
    @Insert({
        "insert into INNODB_LOCKS (lock_id, lock_trx_id, ",
        "lock_mode, lock_type, ",
        "lock_table, lock_index, ",
        "lock_space, lock_page, ",
        "lock_rec, lock_data)",
        "values (#{lockId,jdbcType=VARCHAR}, #{lockTrxId,jdbcType=VARCHAR}, ",
        "#{lockMode,jdbcType=VARCHAR}, #{lockType,jdbcType=VARCHAR}, ",
        "#{lockTable,jdbcType=VARCHAR}, #{lockIndex,jdbcType=VARCHAR}, ",
        "#{lockSpace,jdbcType=BIGINT}, #{lockPage,jdbcType=BIGINT}, ",
        "#{lockRec,jdbcType=BIGINT}, #{lockData,jdbcType=VARCHAR})"
    })
    int insert(InnodbLocks record);

    @Select({
        "select",
        "lock_id, lock_trx_id, lock_mode, lock_type, lock_table, lock_index, lock_space, ",
        "lock_page, lock_rec, lock_data",
        "from INNODB_LOCKS"
    })
    @Results({
        @Result(column="lock_id", property="lockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_trx_id", property="lockTrxId", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_mode", property="lockMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_type", property="lockType", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_table", property="lockTable", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_index", property="lockIndex", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_space", property="lockSpace", jdbcType=JdbcType.BIGINT),
        @Result(column="lock_page", property="lockPage", jdbcType=JdbcType.BIGINT),
        @Result(column="lock_rec", property="lockRec", jdbcType=JdbcType.BIGINT),
        @Result(column="lock_data", property="lockData", jdbcType=JdbcType.VARCHAR)
    })
    List<InnodbLocks> selectAll();
}