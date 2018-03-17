package com.mapper;

import com.model.ReferentialConstraints;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ReferentialConstraintsMapper {
    @Insert({
        "insert into REFERENTIAL_CONSTRAINTS (CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, ",
        "CONSTRAINT_NAME, UNIQUE_CONSTRAINT_CATALOG, ",
        "UNIQUE_CONSTRAINT_SCHEMA, UNIQUE_CONSTRAINT_NAME, ",
        "MATCH_OPTION, UPDATE_RULE, ",
        "DELETE_RULE, TABLE_NAME, ",
        "REFERENCED_TABLE_NAME)",
        "values (#{CONSTRAINT_CATALOG,jdbcType=VARCHAR}, #{CONSTRAINT_SCHEMA,jdbcType=VARCHAR}, ",
        "#{CONSTRAINT_NAME,jdbcType=VARCHAR}, #{UNIQUE_CONSTRAINT_CATALOG,jdbcType=VARCHAR}, ",
        "#{UNIQUE_CONSTRAINT_SCHEMA,jdbcType=VARCHAR}, #{UNIQUE_CONSTRAINT_NAME,jdbcType=VARCHAR}, ",
        "#{MATCH_OPTION,jdbcType=VARCHAR}, #{UPDATE_RULE,jdbcType=VARCHAR}, ",
        "#{DELETE_RULE,jdbcType=VARCHAR}, #{TABLE_NAME,jdbcType=VARCHAR}, ",
        "#{REFERENCED_TABLE_NAME,jdbcType=VARCHAR})"
    })
    int insert(ReferentialConstraints record);

    @Select({
        "select",
        "CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, CONSTRAINT_NAME, UNIQUE_CONSTRAINT_CATALOG, ",
        "UNIQUE_CONSTRAINT_SCHEMA, UNIQUE_CONSTRAINT_NAME, MATCH_OPTION, UPDATE_RULE, ",
        "DELETE_RULE, TABLE_NAME, REFERENCED_TABLE_NAME",
        "from REFERENTIAL_CONSTRAINTS"
    })
    @Results({
        @Result(column="CONSTRAINT_CATALOG", property="CONSTRAINT_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_SCHEMA", property="CONSTRAINT_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_NAME", property="CONSTRAINT_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="UNIQUE_CONSTRAINT_CATALOG", property="UNIQUE_CONSTRAINT_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="UNIQUE_CONSTRAINT_SCHEMA", property="UNIQUE_CONSTRAINT_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="UNIQUE_CONSTRAINT_NAME", property="UNIQUE_CONSTRAINT_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="MATCH_OPTION", property="MATCH_OPTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_RULE", property="UPDATE_RULE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DELETE_RULE", property="DELETE_RULE", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="REFERENCED_TABLE_NAME", property="REFERENCED_TABLE_NAME", jdbcType=JdbcType.VARCHAR)
    })
    List<ReferentialConstraints> selectAll();
}