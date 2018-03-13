package com.mapper;

import com.model.CollationCharacterSetApplicability;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface CollationCharacterSetApplicabilityMapper {
    @Insert({
        "insert into COLLATION_CHARACTER_SET_APPLICABILITY (COLLATION_NAME, CHARACTER_SET_NAME)",
        "values (#{collationName,jdbcType=VARCHAR}, #{characterSetName,jdbcType=VARCHAR})"
    })
    int insert(CollationCharacterSetApplicability record);

    @Select({
        "select",
        "COLLATION_NAME, CHARACTER_SET_NAME",
        "from COLLATION_CHARACTER_SET_APPLICABILITY"
    })
    @Results({
        @Result(column="COLLATION_NAME", property="collationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CHARACTER_SET_NAME", property="characterSetName", jdbcType=JdbcType.VARCHAR)
    })
    List<CollationCharacterSetApplicability> selectAll();
}