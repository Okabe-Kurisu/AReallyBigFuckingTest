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
        "values (#{grantee,jdbcType=VARCHAR}, #{tableCatalog,jdbcType=VARCHAR}, ",
        "#{privilegeType,jdbcType=VARCHAR}, #{isGrantable,jdbcType=VARCHAR})"
    })
    int insert(UserPrivileges record);

    @Select({
        "select",
        "GRANTEE, TABLE_CATALOG, PRIVILEGE_TYPE, IS_GRANTABLE",
        "from USER_PRIVILEGES"
    })
    @Results({
        @Result(column="GRANTEE", property="grantee", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRIVILEGE_TYPE", property="privilegeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_GRANTABLE", property="isGrantable", jdbcType=JdbcType.VARCHAR)
    })
    List<UserPrivileges> selectAll();
}