package com.mapper;

import com.model.CharacterSets;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface CharacterSetsMapper {
    @Insert({
        "insert into CHARACTER_SETS (CHARACTER_SET_NAME, DEFAULT_COLLATE_NAME, ",
        "DESCRIPTION, MAXLEN)",
        "values (#{CHARACTER_SET_NAME,jdbcType=VARCHAR}, #{DEFAULT_COLLATE_NAME,jdbcType=VARCHAR}, ",
        "#{DESCRIPTION,jdbcType=VARCHAR}, #{MAXLEN,jdbcType=BIGINT})"
    })
    int insert(CharacterSets record);

    @Select({
        "select",
        "CHARACTER_SET_NAME, DEFAULT_COLLATE_NAME, DESCRIPTION, MAXLEN",
        "from CHARACTER_SETS"
    })
    @Results({
        @Result(column="CHARACTER_SET_NAME", property="CHARACTER_SET_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_COLLATE_NAME", property="DEFAULT_COLLATE_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="DESCRIPTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAXLEN", property="MAXLEN", jdbcType=JdbcType.BIGINT)
    })
    List<CharacterSets> selectAll();
}