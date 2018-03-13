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
        "values (#{constraintCatalog,jdbcType=VARCHAR}, #{constraintSchema,jdbcType=VARCHAR}, ",
        "#{constraintName,jdbcType=VARCHAR}, #{uniqueConstraintCatalog,jdbcType=VARCHAR}, ",
        "#{uniqueConstraintSchema,jdbcType=VARCHAR}, #{uniqueConstraintName,jdbcType=VARCHAR}, ",
        "#{matchOption,jdbcType=VARCHAR}, #{updateRule,jdbcType=VARCHAR}, ",
        "#{deleteRule,jdbcType=VARCHAR}, #{tableName,jdbcType=VARCHAR}, ",
        "#{referencedTableName,jdbcType=VARCHAR})"
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
        @Result(column="CONSTRAINT_CATALOG", property="constraintCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_SCHEMA", property="constraintSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_NAME", property="constraintName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UNIQUE_CONSTRAINT_CATALOG", property="uniqueConstraintCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="UNIQUE_CONSTRAINT_SCHEMA", property="uniqueConstraintSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="UNIQUE_CONSTRAINT_NAME", property="uniqueConstraintName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MATCH_OPTION", property="matchOption", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_RULE", property="updateRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="DELETE_RULE", property="deleteRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="REFERENCED_TABLE_NAME", property="referencedTableName", jdbcType=JdbcType.VARCHAR)
    })
    List<ReferentialConstraints> selectAll();
}