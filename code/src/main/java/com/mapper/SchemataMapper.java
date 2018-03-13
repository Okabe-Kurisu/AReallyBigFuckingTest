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
        "values (#{catalogName,jdbcType=VARCHAR}, #{schemaName,jdbcType=VARCHAR}, ",
        "#{defaultCharacterSetName,jdbcType=VARCHAR}, #{defaultCollationName,jdbcType=VARCHAR}, ",
        "#{sqlPath,jdbcType=VARCHAR})"
    })
    int insert(Schemata record);

    @Select({
        "select",
        "CATALOG_NAME, SCHEMA_NAME, DEFAULT_CHARACTER_SET_NAME, DEFAULT_COLLATION_NAME, ",
        "SQL_PATH",
        "from SCHEMATA"
    })
    @Results({
        @Result(column="CATALOG_NAME", property="catalogName", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHEMA_NAME", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_CHARACTER_SET_NAME", property="defaultCharacterSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_COLLATION_NAME", property="defaultCollationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_PATH", property="sqlPath", jdbcType=JdbcType.VARCHAR)
    })
    List<Schemata> selectAll();
}