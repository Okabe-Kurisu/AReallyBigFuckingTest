package com.mapper;

import com.model.InnodbCmpmem;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface InnodbCmpmemMapper {
    @Insert({
        "insert into INNODB_CMPMEM (page_size, buffer_pool_instance, ",
        "pages_used, pages_free, ",
        "relocation_ops, relocation_time)",
        "values (#{page_size,jdbcType=INTEGER}, #{buffer_pool_instance,jdbcType=INTEGER}, ",
        "#{pages_used,jdbcType=INTEGER}, #{pages_free,jdbcType=INTEGER}, ",
        "#{relocation_ops,jdbcType=BIGINT}, #{relocation_time,jdbcType=INTEGER})"
    })
    int insert(InnodbCmpmem record);

    @Select({
        "select",
        "page_size, buffer_pool_instance, pages_used, pages_free, relocation_ops, relocation_time",
        "from INNODB_CMPMEM"
    })
    @Results({
        @Result(column="page_size", property="page_size", jdbcType=JdbcType.INTEGER),
        @Result(column="buffer_pool_instance", property="buffer_pool_instance", jdbcType=JdbcType.INTEGER),
        @Result(column="pages_used", property="pages_used", jdbcType=JdbcType.INTEGER),
        @Result(column="pages_free", property="pages_free", jdbcType=JdbcType.INTEGER),
        @Result(column="relocation_ops", property="relocation_ops", jdbcType=JdbcType.BIGINT),
        @Result(column="relocation_time", property="relocation_time", jdbcType=JdbcType.INTEGER)
    })
    List<InnodbCmpmem> selectAll();
}