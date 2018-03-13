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
        "values (#{specificCatalog,jdbcType=VARCHAR}, #{specificSchema,jdbcType=VARCHAR}, ",
        "#{specificName,jdbcType=VARCHAR}, #{ordinalPosition,jdbcType=INTEGER}, ",
        "#{parameterMode,jdbcType=VARCHAR}, #{parameterName,jdbcType=VARCHAR}, ",
        "#{dataType,jdbcType=VARCHAR}, #{characterMaximumLength,jdbcType=INTEGER}, ",
        "#{characterOctetLength,jdbcType=INTEGER}, #{numericPrecision,jdbcType=INTEGER}, ",
        "#{numericScale,jdbcType=INTEGER}, #{characterSetName,jdbcType=VARCHAR}, ",
        "#{collationName,jdbcType=VARCHAR}, #{routineType,jdbcType=VARCHAR}, ",
        "#{dtdIdentifier,jdbcType=LONGVARCHAR})"
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
        @Result(column="SPECIFIC_CATALOG", property="specificCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPECIFIC_SCHEMA", property="specificSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPECIFIC_NAME", property="specificName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDINAL_POSITION", property="ordinalPosition", jdbcType=JdbcType.INTEGER),
        @Result(column="PARAMETER_MODE", property="parameterMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAMETER_NAME", property="parameterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="dataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_MAXIMUM_LENGTH", property="characterMaximumLength", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_OCTET_LENGTH", property="characterOctetLength", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_PRECISION", property="numericPrecision", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_SCALE", property="numericScale", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_SET_NAME", property="characterSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_NAME", property="collationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_TYPE", property="routineType", jdbcType=JdbcType.VARCHAR),
        @Result(column="DTD_IDENTIFIER", property="dtdIdentifier", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Parameters> selectAll();
}