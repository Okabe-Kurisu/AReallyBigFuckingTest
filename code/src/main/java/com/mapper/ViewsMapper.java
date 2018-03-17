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
        "values (#{TABLE_CATALOG,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{CHECK_OPTION,jdbcType=VARCHAR}, ",
        "#{IS_UPDATABLE,jdbcType=VARCHAR}, #{DEFINER,jdbcType=VARCHAR}, ",
        "#{SECURITY_TYPE,jdbcType=VARCHAR}, #{CHARACTER_SET_CLIENT,jdbcType=VARCHAR}, ",
        "#{COLLATION_CONNECTION,jdbcType=VARCHAR}, #{VIEW_DEFINITION,jdbcType=LONGVARCHAR})"
    })
    int insert(Views record);

    @Select({
        "select",
        "TABLE_CATALOG, TABLE_SCHEMA, TABLE_NAME, CHECK_OPTION, IS_UPDATABLE, DEFINER, ",
        "SECURITY_TYPE, CHARACTER_SET_CLIENT, COLLATION_CONNECTION, VIEW_DEFINITION",
        "from VIEWS"
    })
    @Results({
        @Result(column="TABLE_CATALOG", property="TABLE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHECK_OPTION", property="CHECK_OPTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_UPDATABLE", property="IS_UPDATABLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFINER", property="DEFINER", jdbcType=JdbcType.VARCHAR),
        @Result(column="SECURITY_TYPE", property="SECURITY_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_CLIENT", property="CHARACTER_SET_CLIENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_CONNECTION", property="COLLATION_CONNECTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="VIEW_DEFINITION", property="VIEW_DEFINITION", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Views> selectAll();
}