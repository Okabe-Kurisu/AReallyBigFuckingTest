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
        "values (#{CONSTRAINT_CATALOG,jdbcType=VARCHAR}, #{CONSTRAINT_SCHEMA,jdbcType=VARCHAR}, ",
        "#{CONSTRAINT_NAME,jdbcType=VARCHAR}, #{TABLE_SCHEMA,jdbcType=VARCHAR}, ",
        "#{TABLE_NAME,jdbcType=VARCHAR}, #{CONSTRAINT_TYPE,jdbcType=VARCHAR})"
    })
    int insert(TableConstraints record);

    @Select({
        "select",
        "CONSTRAINT_CATALOG, CONSTRAINT_SCHEMA, CONSTRAINT_NAME, TABLE_SCHEMA, TABLE_NAME, ",
        "CONSTRAINT_TYPE",
        "from TABLE_CONSTRAINTS"
    })
    @Results({
        @Result(column="CONSTRAINT_CATALOG", property="CONSTRAINT_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_SCHEMA", property="CONSTRAINT_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_NAME", property="CONSTRAINT_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_SCHEMA", property="TABLE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="TABLE_NAME", property="TABLE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONSTRAINT_TYPE", property="CONSTRAINT_TYPE", jdbcType=JdbcType.VARCHAR)
    })
    List<TableConstraints> selectAll();
}