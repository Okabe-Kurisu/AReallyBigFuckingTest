package com.mapper;

import com.model.Schemata;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface SchemataMapper {
    @Insert({
        "insert into SCHEMATA (CATALOG_NAME, SCHEMA_NAME, ",
        "DEFAULT_CHARACTER_SET_NAME, DEFAULT_COLLATION_NAME, ",
        "SQL_PATH)",
        "values (#{CATALOG_NAME,jdbcType=VARCHAR}, #{SCHEMA_NAME,jdbcType=VARCHAR}, ",
        "#{DEFAULT_CHARACTER_SET_NAME,jdbcType=VARCHAR}, #{DEFAULT_COLLATION_NAME,jdbcType=VARCHAR}, ",
        "#{SQL_PATH,jdbcType=VARCHAR})"
    })
    int insert(Schemata record);

    @Select({
        "select",
        "CATALOG_NAME, SCHEMA_NAME, DEFAULT_CHARACTER_SET_NAME, DEFAULT_COLLATION_NAME, ",
        "SQL_PATH",
        "from SCHEMATA"
    })
    @Results({
        @Result(column="CATALOG_NAME", property="CATALOG_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHEMA_NAME", property="SCHEMA_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_CHARACTER_SET_NAME", property="DEFAULT_CHARACTER_SET_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_COLLATION_NAME", property="DEFAULT_COLLATION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_PATH", property="SQL_PATH", jdbcType=JdbcType.VARCHAR)
    })
    List<Schemata> selectAll();
}