package com.mapper;

import com.model.SearchLog;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface SearchLogMapper {
    @Insert({
        "insert into search_log (slid, user_id, ",
        "content, date)",
        "values (#{slid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{date,jdbcType=TIMESTAMP})"
    })
    int insert(SearchLog record);

    @Select({
        "select",
        "slid, user_id, content, date",
        "from search_log"
    })
    @Results({
        @Result(column="slid", property="slid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SearchLog> selectAll();
}