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
        "values (#{page_size,jdbcType=INTEGER}, #{compress_ops,jdbcType=INTEGER}, ",
        "#{compress_ops_ok,jdbcType=INTEGER}, #{compress_time,jdbcType=INTEGER}, ",
        "#{uncompress_ops,jdbcType=INTEGER}, #{uncompress_time,jdbcType=INTEGER})"
    })
    int insert(InnodbCmpReset record);

    @Select({
        "select",
        "page_size, compress_ops, compress_ops_ok, compress_time, uncompress_ops, uncompress_time",
        "from INNODB_CMP_RESET"
    })
    @Results({
        @Result(column="page_size", property="page_size", jdbcType=JdbcType.INTEGER),
        @Result(column="compress_ops", property="compress_ops", jdbcType=JdbcType.INTEGER),
        @Result(column="compress_ops_ok", property="compress_ops_ok", jdbcType=JdbcType.INTEGER),
        @Result(column="compress_time", property="compress_time", jdbcType=JdbcType.INTEGER),
        @Result(column="uncompress_ops", property="uncompress_ops", jdbcType=JdbcType.INTEGER),
        @Result(column="uncompress_time", property="uncompress_time", jdbcType=JdbcType.INTEGER)
    })
    List<InnodbCmpReset> selectAll();
}