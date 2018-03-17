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
        "values (#{lock_id,jdbcType=VARCHAR}, #{lock_trx_id,jdbcType=VARCHAR}, ",
        "#{lock_mode,jdbcType=VARCHAR}, #{lock_type,jdbcType=VARCHAR}, ",
        "#{lock_table,jdbcType=VARCHAR}, #{lock_index,jdbcType=VARCHAR}, ",
        "#{lock_space,jdbcType=BIGINT}, #{lock_page,jdbcType=BIGINT}, ",
        "#{lock_rec,jdbcType=BIGINT}, #{lock_data,jdbcType=VARCHAR})"
    })
    int insert(InnodbLocks record);

    @Select({
        "select",
        "lock_id, lock_trx_id, lock_mode, lock_type, lock_table, lock_index, lock_space, ",
        "lock_page, lock_rec, lock_data",
        "from INNODB_LOCKS"
    })
    @Results({
        @Result(column="lock_id", property="lock_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_trx_id", property="lock_trx_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_mode", property="lock_mode", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_type", property="lock_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_table", property="lock_table", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_index", property="lock_index", jdbcType=JdbcType.VARCHAR),
        @Result(column="lock_space", property="lock_space", jdbcType=JdbcType.BIGINT),
        @Result(column="lock_page", property="lock_page", jdbcType=JdbcType.BIGINT),
        @Result(column="lock_rec", property="lock_rec", jdbcType=JdbcType.BIGINT),
        @Result(column="lock_data", property="lock_data", jdbcType=JdbcType.VARCHAR)
    })
    List<InnodbLocks> selectAll();
}