package com.mapper;

import com.model.UserPrivileges;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface UserPrivilegesMapper {
    @Insert({
        "insert into USER_PRIVILEGES (GRANTEE, TABLE_CATALOG, ",
        "PRIVILEGE_TYPE, IS_GRANTABLE)",
        "values (#{GRANTEE,jdbcType=VARCHAR}, #{TABLE_CATALOG,jdbcType=VARCHAR}, ",
        "#{PRIVILEGE_TYPE,jdbcType=VARCHAR}, #{IS_GRANTABLE,jdbcType=VARCHAR})"
    })
    int insert(UserPrivileges record);

    @Select({
        "select",
        "GRANTEE, TABLE_CATALOG, PRIVILEGE_TYPE, IS_GRANTABLE",
        "from USER_PRIVILEGES"
    })
    @Results({
        @Result(column="GRANTEE", property="GRANTEE", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRIVILEGE_TYPE", property="PRIVILEGE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_GRANTABLE", property="IS_GRANTABLE", jdbcType=JdbcType.VARCHAR)
    })
    List<UserPrivileges> selectAll();
}