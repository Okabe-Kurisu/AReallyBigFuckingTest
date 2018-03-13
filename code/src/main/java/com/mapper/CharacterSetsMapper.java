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
        "values (#{characterSetName,jdbcType=VARCHAR}, #{defaultCollateName,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{maxlen,jdbcType=BIGINT})"
    })
    int insert(CharacterSets record);

    @Select({
        "select",
        "CHARACTER_SET_NAME, DEFAULT_COLLATE_NAME, DESCRIPTION, MAXLEN",
        "from CHARACTER_SETS"
    })
    @Results({
        @Result(column="CHARACTER_SET_NAME", property="characterSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DEFAULT_COLLATE_NAME", property="defaultCollateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAXLEN", property="maxlen", jdbcType=JdbcType.BIGINT)
    })
    List<CharacterSets> selectAll();
}