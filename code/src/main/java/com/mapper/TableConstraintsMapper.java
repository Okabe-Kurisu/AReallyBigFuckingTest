package com.mapper;

import com.model.TableConstraints;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface TableConstraintsMapper {
    @Insert({
        "insert into TABLE_CONSTRAINTS (CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, ",
        "CONSTRAINT_NAME, TABLE_SCHEMA, ",
        "TABLE_NAME, CONSTRAINT_TYPE)",
        "values (#{constraintCatalog,jdbcType=VARCHAR}, #{constraintSchema,jdbcType=VARCHAR}, ",
        "#{constraintName,jdbcType=VARCHAR}, #{tableSchema,jdbcType=VARCHAR}, ",
        "#{tableName,jdbcType=VARCHAR}, #{constraintType,jdbcType=VARCHAR})"
    })
    int insert(TableConstraints record);

    @Select({
        "select",
        "CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, CONSTRAINT_NAME, TABLE_SCHEMA, TABLE_NAME, ",
        "CONSTRAINT_TYPE",
        "from TABLE_CONSTRAINTS"
    })
    @Results({
        @Result(column="CONSTRAINT_CATALOG", property="constraintCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_SCHEMA", property="constraintSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_NAME", property="constraintName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="tableSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_TYPE", property="constraintType", jdbcType=JdbcType.VARCHAR)
    })
    List<TableConstraints> selectAll();
}