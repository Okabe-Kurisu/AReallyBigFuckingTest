package com.mapper;

import com.model.Routines;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface RoutinesMapper {
    @Insert({
        "insert into ROUTINES (SPECIFIC_NAME, ROUTINE_CATALOG, ",
        "ROUTINE_SCHEMA, ROUTINE_NAME, ",
        "ROUTINE_TYPE, DATA_TYPE, ",
        "CHARACTER_MAXIMUM_LENGTH, CHARACTER_OCTET_LENGTH, ",
        "NUMERIC_PRECISION, NUMERIC_SCALE, ",
        "CHARACTER_SET_NAME, COLLATION_NAME, ",
        "ROUTINE_BODY, EXTERNAL_NAME, ",
        "EXTERNAL_LANGUAGE, PARAMETER_STYLE, ",
        "IS_DETERMINISTIC, SQL_DATA_ACCESS, ",
        "SQL_PATH, SECURITY_TYPE, ",
        "CREATED, LAST_ALTERED, ",
        "SQL_MODE, DEFINER, ",
        "CHARACTER_SET_CLIENT, COLLATION_CONNECTION, ",
        "DATABASE_COLLATION, DTD_IDENTIFIER, ",
        "ROUTINE_DEFINITION, ROUTINE_COMMENT)",
        "values (#{SPECIFIC_NAME,jdbcType=VARCHAR}, #{ROUTINE_CATALOG,jdbcType=VARCHAR}, ",
        "#{ROUTINE_SCHEMA,jdbcType=VARCHAR}, #{ROUTINE_NAME,jdbcType=VARCHAR}, ",
        "#{ROUTINE_TYPE,jdbcType=VARCHAR}, #{DATA_TYPE,jdbcType=VARCHAR}, ",
        "#{CHARACTER_MAXIMUM_LENGTH,jdbcType=INTEGER}, #{CHARACTER_OCTET_LENGTH,jdbcType=INTEGER}, ",
        "#{NUMERIC_PRECISION,jdbcType=INTEGER}, #{NUMERIC_SCALE,jdbcType=INTEGER}, ",
        "#{CHARACTER_SET_NAME,jdbcType=VARCHAR}, #{COLLATION_NAME,jdbcType=VARCHAR}, ",
        "#{ROUTINE_BODY,jdbcType=VARCHAR}, #{EXTERNAL_NAME,jdbcType=VARCHAR}, ",
        "#{EXTERNAL_LANGUAGE,jdbcType=VARCHAR}, #{PARAMETER_STYLE,jdbcType=VARCHAR}, ",
        "#{IS_DETERMINISTIC,jdbcType=VARCHAR}, #{SQL_DATA_ACCESS,jdbcType=VARCHAR}, ",
        "#{SQL_PATH,jdbcType=VARCHAR}, #{SECURITY_TYPE,jdbcType=VARCHAR}, ",
        "#{CREATED,jdbcType=TIMESTAMP}, #{LAST_ALTERED,jdbcType=TIMESTAMP}, ",
        "#{SQL_MODE,jdbcType=VARCHAR}, #{DEFINER,jdbcType=VARCHAR}, ",
        "#{CHARACTER_SET_CLIENT,jdbcType=VARCHAR}, #{COLLATION_CONNECTION,jdbcType=VARCHAR}, ",
        "#{DATABASE_COLLATION,jdbcType=VARCHAR}, #{DTD_IDENTIFIER,jdbcType=LONGVARCHAR}, ",
        "#{ROUTINE_DEFINITION,jdbcType=LONGVARCHAR}, #{ROUTINE_COMMENT,jdbcType=LONGVARCHAR})"
    })
    int insert(Routines record);

    @Select({
        "select",
        "SPECIFIC_NAME, ROUTINE_CATALOG, ROUTINE_SCHEMA, ROUTINE_NAME, ROUTINE_TYPE, ",
        "DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, CHARACTER_OCTET_LENGTH, NUMERIC_PRECISION, ",
        "NUMERIC_SCALE, CHARACTER_SET_NAME, COLLATION_NAME, ROUTINE_BODY, EXTERNAL_NAME, ",
        "EXTERNAL_LANGUAGE, PARAMETER_STYLE, IS_DETERMINISTIC, SQL_DATA_ACCESS, SQL_PATH, ",
        "SECURITY_TYPE, CREATED, LAST_ALTERED, SQL_MODE, DEFINER, CHARACTER_SET_CLIENT, ",
        "COLLATION_CONNECTION, DATABASE_COLLATION, DTD_IDENTIFIER, ROUTINE_DEFINITION, ",
        "ROUTINE_COMMENT",
        "from ROUTINES"
    })
    @Results({
        @Result(column="SPECIFIC_NAME", property="SPECIFIC_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_CATALOG", property="ROUTINE_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_SCHEMA", property="ROUTINE_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_NAME", property="ROUTINE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_TYPE", property="ROUTINE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="DATA_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_MAXIMUM_LENGTH", property="CHARACTER_MAXIMUM_LENGTH", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_OCTET_LENGTH", property="CHARACTER_OCTET_LENGTH", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_PRECISION", property="NUMERIC_PRECISION", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_SCALE", property="NUMERIC_SCALE", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_SET_NAME", property="CHARACTER_SET_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_NAME", property="COLLATION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_BODY", property="ROUTINE_BODY", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTERNAL_NAME", property="EXTERNAL_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTERNAL_LANGUAGE", property="EXTERNAL_LANGUAGE", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAMETER_STYLE", property="PARAMETER_STYLE", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_DETERMINISTIC", property="IS_DETERMINISTIC", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_DATA_ACCESS", property="SQL_DATA_ACCESS", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_PATH", property="SQL_PATH", jdbcType=JdbcType.VARCHAR),
        @Result(column="SECURITY_TYPE", property="SECURITY_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED", property="CREATED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_ALTERED", property="LAST_ALTERED", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SQL_MODE", property="SQL_MODE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFINER", property="DEFINER", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_CLIENT", property="CHARACTER_SET_CLIENT", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_CONNECTION", property="COLLATION_CONNECTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATABASE_COLLATION", property="DATABASE_COLLATION", jdbcType=JdbcType.VARCHAR),
        @Result(column="DTD_IDENTIFIER", property="DTD_IDENTIFIER", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ROUTINE_DEFINITION", property="ROUTINE_DEFINITION", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ROUTINE_COMMENT", property="ROUTINE_COMMENT", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Routines> selectAll();
}