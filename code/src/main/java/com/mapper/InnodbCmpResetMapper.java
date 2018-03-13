package com.mapper;

import com.model.InnodbCmpReset;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbCmpResetMapper {
    @Insert({
        "insert into INNODB_CMP_RESET (page_size, compress_ops, ",
        "compress_ops_ok, compress_time, ",
        "uncompress_ops, uncompress_time)",
        "values (#{pageSize,jdbcType=INTEGER}, #{compressOps,jdbcType=INTEGER}, ",
        "#{compressOpsOk,jdbcType=INTEGER}, #{compressTime,jdbcType=INTEGER}, ",
        "#{uncompressOps,jdbcType=INTEGER}, #{uncompressTime,jdbcType=INTEGER})"
    })
    int insert(InnodbCmpReset record);

    @Select({
        "select",
        "page_size, compress_ops, compress_ops_ok, compress_time, uncompress_ops, uncompress_time",
        "from INNODB_CMP_RESET"
    })
    @Results({
        @Result(column="page_size", property="pageSize", jdbcType=JdbcType.INTEGER),
        @Result(column="compress_ops", property="compressOps", jdbcType=JdbcType.INTEGER),
        @Result(column="compress_ops_ok", property="compressOpsOk", jdbcType=JdbcType.INTEGER),
        @Result(column="compress_time", property="compressTime", jdbcType=JdbcType.INTEGER),
        @Result(column="uncompress_ops", property="uncompressOps", jdbcType=JdbcType.INTEGER),
        @Result(column="uncompress_time", property="uncompressTime", jdbcType=JdbcType.INTEGER)
    })
    List<InnodbCmpReset> selectAll();
}