package com.mapper;

import com.model.Views;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ViewsMapper {
    @Insert({
        "insert into VIEWS (TABLE_CATALOG, TABLE_SCHEMA, ",
        "TABLE_NAME, CHECK_OPTION, ",
        "IS_UPDATABLE, DEFINER, ",
        "SECURITY_TYPE, CHARACTER_SET_CLIENT, ",
        "COLLATION_CONNECTION, VIEW_DEFINITION)",
        "values (#{tableCatalog,jdbcType=VARCHAR}, #{tableSchema,jdbcType=VARCHAR}, ",
        "#{tableName,jdbcType=VARCHAR}, #{checkOption,jdbcType=VARCHAR}, ",
        "#{isUpdatable,jdbcType=VARCHAR}, #{definer,jdbcType=VARCHAR}, ",
        "#{securityType,jdbcType=VARCHAR}, #{characterSetClient,jdbcType=VARCHAR}, ",
        "#{collationConnection,jdbcType=VARCHAR}, #{viewDefinition,jdbcType=LONGVARCHAR})"
    })
    int insert(Views record);

    @Select({
        "select",
        "TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, CHECK_OPTION, IS_UPDATABLE, DEFINER, ",
        "SECURITY_TYPE, CHARACTER_SET_CLIENT, COLLATION_CONNECTION, VIEW_DEFINITION",
        "from VIEWS"
    })
    @Results({
        @Result(column="TABLE_CATALOG", property="tableCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHECK_OPTION", property="checkOption", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_UPDATABLE", property="isUpdatable", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFINER", property="definer", jdbcType=JdbcType.VARCHAR),
        @Result(column="SECURITY_TYPE", property="securityType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_CLIENT", property="characterSetClient", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_CONNECTION", property="collationConnection", jdbcType=JdbcType.VARCHAR),
        @Result(column="VIEW_DEFINITION", property="viewDefinition", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Views> selectAll();
}