package com.mapper;

import com.model.Collations;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface CollationsMapper {
    @Insert({
        "insert into COLLATIONS (COLLATION_NAME, CHARACTER_SET_NAME, ",
        "ID, IS_DEFAULT, IS_COMPILED, ",
        "SORTLEN)",
        "values (#{collationName,jdbcType=VARCHAR}, #{characterSetName,jdbcType=VARCHAR}, ",
        "#{id,jdbcType=BIGINT}, #{isDefault,jdbcType=VARCHAR}, #{isCompiled,jdbcType=VARCHAR}, ",
        "#{sortlen,jdbcType=BIGINT})"
    })
    int insert(Collations record);

    @Select({
        "select",
        "COLLATION_NAME, CHARACTER_SET_NAME, ID, IS_DEFAULT, IS_COMPILED, SORTLEN",
        "from COLLATIONS"
    })
    @Results({
        @Result(column="COLLATION_NAME", property="collationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_NAME", property="characterSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_DEFAULT", property="isDefault", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_COMPILED", property="isCompiled", jdbcType=JdbcType.VARCHAR),
        @Result(column="SORTLEN", property="sortlen", jdbcType=JdbcType.BIGINT)
    })
    List<Collations> selectAll();
}