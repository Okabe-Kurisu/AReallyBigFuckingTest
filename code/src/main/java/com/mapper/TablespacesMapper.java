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
        "values (#{tablespaceName,jdbcType=VARCHAR}, #{engine,jdbcType=VARCHAR}, ",
        "#{tablespaceType,jdbcType=VARCHAR}, #{logfileGroupName,jdbcType=VARCHAR}, ",
        "#{extentSize,jdbcType=BIGINT}, #{autoextendSize,jdbcType=BIGINT}, ",
        "#{maximumSize,jdbcType=BIGINT}, #{nodegroupId,jdbcType=BIGINT}, ",
        "#{tablespaceComment,jdbcType=VARCHAR})"
    })
    int insert(Tablespaces record);

    @Select({
        "select",
        "TABLESPACE_NAME, ENGINE, TABLESPACE_TYPE, LOGFILE_GROUP_NAME, EXTENT_SIZE, AUTOEXTEND_SIZE, ",
        "MAXIMUM_SIZE, NODEGROUP_ID, TABLESPACE_COMMENT",
        "from TABLESPACES"
    })
    @Results({
        @Result(column="TABLESPACE_NAME", property="tablespaceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ENGINE", property="engine", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLESPACE_TYPE", property="tablespaceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOGFILE_GROUP_NAME", property="logfileGroupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENT_SIZE", property="extentSize", jdbcType=JdbcType.BIGINT),
        @Result(column="AUTOEXTEND_SIZE", property="autoextendSize", jdbcType=JdbcType.BIGINT),
        @Result(column="MAXIMUM_SIZE", property="maximumSize", jdbcType=JdbcType.BIGINT),
        @Result(column="NODEGROUP_ID", property="nodegroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="TABLESPACE_COMMENT", property="tablespaceComment", jdbcType=JdbcType.VARCHAR)
    })
    List<Tablespaces> selectAll();
}