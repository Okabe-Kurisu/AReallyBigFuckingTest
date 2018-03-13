package com.mapper;

import com.model.TablePrivileges;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface TablePrivilegesMapper {
    @Insert({
        "insert into TABLE_PRIVILEGES (GRANTEE, TABLE_CATALOG, ",
        "TABLE_SCHEMA, TABLE_NAME, ",
        "PRIVILEGE_TYPE, IS_GRANTABLE)",
        "values (#{grantee,jdbcType=VARCHAR}, #{tableCatalog,jdbcType=VARCHAR}, ",
        "#{tableSchema,jdbcType=VARCHAR}, #{tableName,jdbcType=VARCHAR}, ",
        "#{privilegeType,jdbcType=VARCHAR}, #{isGrantable,jdbcType=VARCHAR})"
    })
    int insert(TablePrivileges record);

    @Select({
        "select",
        "GRANTEE, TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, PRIVILEGE_TYPE, IS_GRANTABLE",
        "from TABLE_PRIVILEGES"
    })
    @Results({
        @Result(column="GRANTEE", property="grantee", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRIVILEGE_TYPE", property="privilegeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_GRANTABLE", property="isGrantable", jdbcType=JdbcType.VARCHAR)
    })
    List<TablePrivileges> selectAll();
}