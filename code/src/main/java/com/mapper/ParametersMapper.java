package com.mapper;

import com.model.Parameters;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface ParametersMapper {
    @Insert({
        "insert into PARAMETERS (SPECIFIC_CATALOG, SPECIFIC_SCHEMA, ",
        "SPECIFIC_NAME, ORDINAL_POSITION, ",
        "PARAMETER_MODE, PARAMETER_NAME, ",
        "DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, ",
        "CHARACTER_OCTET_LENGTH, NUMERIC_PRECISION, ",
        "NUMERIC_SCALE, CHARACTER_SET_NAME, ",
        "COLLATION_NAME, ROUTINE_TYPE, ",
        "DTD_IDENTIFIER)",
        "values (#{SPECIFIC_CATALOG,jdbcType=VARCHAR}, #{SPECIFIC_SCHEMA,jdbcType=VARCHAR}, ",
        "#{SPECIFIC_NAME,jdbcType=VARCHAR}, #{ORDINAL_POSITION,jdbcType=INTEGER}, ",
        "#{PARAMETER_MODE,jdbcType=VARCHAR}, #{PARAMETER_NAME,jdbcType=VARCHAR}, ",
        "#{DATA_TYPE,jdbcType=VARCHAR}, #{CHARACTER_MAXIMUM_LENGTH,jdbcType=INTEGER}, ",
        "#{CHARACTER_OCTET_LENGTH,jdbcType=INTEGER}, #{NUMERIC_PRECISION,jdbcType=INTEGER}, ",
        "#{NUMERIC_SCALE,jdbcType=INTEGER}, #{CHARACTER_SET_NAME,jdbcType=VARCHAR}, ",
        "#{COLLATION_NAME,jdbcType=VARCHAR}, #{ROUTINE_TYPE,jdbcType=VARCHAR}, ",
        "#{DTD_IDENTIFIER,jdbcType=LONGVARCHAR})"
    })
    int insert(Parameters record);

    @Select({
        "select",
        "SPECIFIC_CATALOG, SPECIFIC_SCHEMA, SPECIFIC_NAME, ORDINAL_POSITION, PARAMETER_MODE, ",
        "PARAMETER_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, CHARACTER_OCTET_LENGTH, ",
        "NUMERIC_PRECISION, NUMERIC_SCALE, CHARACTER_SET_NAME, COLLATION_NAME, ROUTINE_TYPE, ",
        "DTD_IDENTIFIER",
        "from PARAMETERS"
    })
    @Results({
        @Result(column="SPECIFIC_CATALOG", property="SPECIFIC_CATALOG", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPECIFIC_SCHEMA", property="SPECIFIC_SCHEMA", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPECIFIC_NAME", property="SPECIFIC_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDINAL_POSITION", property="ORDINAL_POSITION", jdbcType=JdbcType.INTEGER),
        @Result(column="PARAMETER_MODE", property="PARAMETER_MODE", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAMETER_NAME", property="PARAMETER_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="DATA_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_MAXIMUM_LENGTH", property="CHARACTER_MAXIMUM_LENGTH", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_OCTET_LENGTH", property="CHARACTER_OCTET_LENGTH", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_PRECISION", property="NUMERIC_PRECISION", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_SCALE", property="NUMERIC_SCALE", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_SET_NAME", property="CHARACTER_SET_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_NAME", property="COLLATION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_TYPE", property="ROUTINE_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="DTD_IDENTIFIER", property="DTD_IDENTIFIER", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Parameters> selectAll();
}