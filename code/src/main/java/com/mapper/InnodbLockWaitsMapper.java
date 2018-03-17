package com.mapper;

import com.model.InnodbLockWaits;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbLockWaitsMapper {
    @Insert({
        "insert into INNODB_LOCK_WAITS (requesting_trx_id, requested_lock_id, ",
        "blocking_trx_id, blocking_lock_id)",
        "values (#{requesting_trx_id,jdbcType=VARCHAR}, #{requested_lock_id,jdbcType=VARCHAR}, ",
        "#{blocking_trx_id,jdbcType=VARCHAR}, #{blocking_lock_id,jdbcType=VARCHAR})"
    })
    int insert(InnodbLockWaits record);

    @Select({
        "select",
        "requesting_trx_id, requested_lock_id, blocking_trx_id, blocking_lock_id",
        "from INNODB_LOCK_WAITS"
    })
    @Results({
        @Result(column="requesting_trx_id", property="requesting_trx_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="requested_lock_id", property="requested_lock_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="blocking_trx_id", property="blocking_trx_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="blocking_lock_id", property="blocking_lock_id", jdbcType=JdbcType.VARCHAR)
    })
    List<InnodbLockWaits> selectAll();
}