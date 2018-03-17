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
        "values (#{COLLATION_NAME,jdbcType=VARCHAR}, #{CHARACTER_SET_NAME,jdbcType=VARCHAR}, ",
        "#{ID,jdbcType=BIGINT}, #{IS_DEFAULT,jdbcType=VARCHAR}, #{IS_COMPILED,jdbcType=VARCHAR}, ",
        "#{SORTLEN,jdbcType=BIGINT})"
    })
    int insert(Collations record);

    @Select({
        "select",
        "COLLATION_NAME, CHARACTER_SET_NAME, ID, IS_DEFAULT, IS_COMPILED, SORTLEN",
        "from COLLATIONS"
    })
    @Results({
        @Result(column="COLLATION_NAME", property="COLLATION_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_NAME", property="CHARACTER_SET_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="ID", property="ID", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_DEFAULT", property="IS_DEFAULT", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_COMPILED", property="IS_COMPILED", jdbcType=JdbcType.VARCHAR),
        @Result(column="SORTLEN", property="SORTLEN", jdbcType=JdbcType.BIGINT)
    })
    List<Collations> selectAll();
}