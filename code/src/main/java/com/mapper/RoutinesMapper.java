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
        "values (#{specificName,jdbcType=VARCHAR}, #{routineCatalog,jdbcType=VARCHAR}, ",
        "#{routineSchema,jdbcType=VARCHAR}, #{routineName,jdbcType=VARCHAR}, ",
        "#{routineType,jdbcType=VARCHAR}, #{dataType,jdbcType=VARCHAR}, ",
        "#{characterMaximumLength,jdbcType=INTEGER}, #{characterOctetLength,jdbcType=INTEGER}, ",
        "#{numericPrecision,jdbcType=INTEGER}, #{numericScale,jdbcType=INTEGER}, ",
        "#{characterSetName,jdbcType=VARCHAR}, #{collationName,jdbcType=VARCHAR}, ",
        "#{routineBody,jdbcType=VARCHAR}, #{externalName,jdbcType=VARCHAR}, ",
        "#{externalLanguage,jdbcType=VARCHAR}, #{parameterStyle,jdbcType=VARCHAR}, ",
        "#{isDeterministic,jdbcType=VARCHAR}, #{sqlDataAccess,jdbcType=VARCHAR}, ",
        "#{sqlPath,jdbcType=VARCHAR}, #{securityType,jdbcType=VARCHAR}, ",
        "#{created,jdbcType=TIMESTAMP}, #{lastAltered,jdbcType=TIMESTAMP}, ",
        "#{sqlMode,jdbcType=VARCHAR}, #{definer,jdbcType=VARCHAR}, ",
        "#{characterSetClient,jdbcType=VARCHAR}, #{collationConnection,jdbcType=VARCHAR}, ",
        "#{databaseCollation,jdbcType=VARCHAR}, #{dtdIdentifier,jdbcType=LONGVARCHAR}, ",
        "#{routineDefinition,jdbcType=LONGVARCHAR}, #{routineComment,jdbcType=LONGVARCHAR})"
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
        @Result(column="SPECIFIC_NAME", property="specificName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_CATALOG", property="routineCatalog", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_SCHEMA", property="routineSchema", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_NAME", property="routineName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_TYPE", property="routineType", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_TYPE", property="dataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_MAXIMUM_LENGTH", property="characterMaximumLength", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_OCTET_LENGTH", property="characterOctetLength", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_PRECISION", property="numericPrecision", jdbcType=JdbcType.INTEGER),
        @Result(column="NUMERIC_SCALE", property="numericScale", jdbcType=JdbcType.INTEGER),
        @Result(column="CHARACTER_SET_NAME", property="characterSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_NAME", property="collationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROUTINE_BODY", property="routineBody", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTERNAL_NAME", property="externalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTERNAL_LANGUAGE", property="externalLanguage", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAMETER_STYLE", property="parameterStyle", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_DETERMINISTIC", property="isDeterministic", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_DATA_ACCESS", property="sqlDataAccess", jdbcType=JdbcType.VARCHAR),
        @Result(column="SQL_PATH", property="sqlPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="SECURITY_TYPE", property="securityType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED", property="created", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LAST_ALTERED", property="lastAltered", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SQL_MODE", property="sqlMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFINER", property="definer", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_CLIENT", property="characterSetClient", jdbcType=JdbcType.VARCHAR),
        @Result(column="COLLATION_CONNECTION", property="collationConnection", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATABASE_COLLATION", property="databaseCollation", jdbcType=JdbcType.VARCHAR),
        @Result(column="DTD_IDENTIFIER", property="dtdIdentifier", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ROUTINE_DEFINITION", property="routineDefinition", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ROUTINE_COMMENT", property="routineComment", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Routines> selectAll();
}