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
        "values (#{pageSize,jdbcType=INTEGER}, #{bufferPoolInstance,jdbcType=INTEGER}, ",
        "#{pagesUsed,jdbcType=INTEGER}, #{pagesFree,jdbcType=INTEGER}, ",
        "#{relocationOps,jdbcType=BIGINT}, #{relocationTime,jdbcType=INTEGER})"
    })
    int insert(InnodbCmpmem record);

    @Select({
        "select",
        "page_size, buffer_pool_instance, pages_used, pages_free, relocation_ops, relocation_time",
        "from INNODB_CMPMEM"
    })
    @Results({
        @Result(column="page_size", property="pageSize", jdbcType=JdbcType.INTEGER),
        @Result(column="buffer_pool_instance", property="bufferPoolInstance", jdbcType=JdbcType.INTEGER),
        @Result(column="pages_used", property="pagesUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="pages_free", property="pagesFree", jdbcType=JdbcType.INTEGER),
        @Result(column="relocation_ops", property="relocationOps", jdbcType=JdbcType.BIGINT),
        @Result(column="relocation_time", property="relocationTime", jdbcType=JdbcType.INTEGER)
    })
    List<InnodbCmpmem> selectAll();
}