package com.mapper;

import com.model.Tablespaces;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface TablespacesMapper {
    @Insert({
        "insert into TABLESPACES (TABLESPACE_NAME, ENGINE, ",
        "TABLESPACE_TYPE, LOGFILE_GROUP_NAME, ",
        "EXTENT_SIZE, AUTOEXTEND_SIZE, ",
        "MAXIMUM_SIZE, NODEGROUP_ID, ",
        "TABLESPACE_COMMENT)",
        "values (#{TABLESPACE_NAME,jdbcType=VARCHAR}, #{ENGINE,jdbcType=VARCHAR}, ",
        "#{TABLESPACE_TYPE,jdbcType=VARCHAR}, #{LOGFILE_GROUP_NAME,jdbcType=VARCHAR}, ",
        "#{EXTENT_SIZE,jdbcType=BIGINT}, #{AUTOEXTEND_SIZE,jdbcType=BIGINT}, ",
        "#{MAXIMUM_SIZE,jdbcType=BIGINT}, #{NODEGROUP_ID,jdbcType=BIGINT}, ",
        "#{TABLESPACE_COMMENT,jdbcType=VARCHAR})"
    })
    int insert(Tablespaces record);

    @Select({
        "select",
        "TABLESPACE_NAME, ENGINE, TABLESPACE_TYPE, LOGFILE_GROUP_NAME, EXTENT_SIZE, AUTOEXTEND_SIZE, ",
        "MAXIMUM_SIZE, NODEGROUP_ID, TABLESPACE_COMMENT",
        "from TABLESPACES"
    })
    @Results({
        @Result(column="TABLESPACE_NAME", property="TABLESPACE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENGINE", property="ENGINE", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLESPACE_TYPE", property="TABLESPACE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOGFILE_GROUP_NAME", property="LOGFILE_GROUP_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENT_SIZE", property="EXTENT_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="AUTOEXTEND_SIZE", property="AUTOEXTEND_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="MAXIMUM_SIZE", property="MAXIMUM_SIZE", jdbcType=JdbcType.BIGINT),
        @Result(column="NODEGROUP_ID", property="NODEGROUP_ID", jdbcType=JdbcType.BIGINT),
        @Result(column="TABLESPACE_COMMENT", property="TABLESPACE_COMMENT", jdbcType=JdbcType.VARCHAR)
    })
    List<Tablespaces> selectAll();
}