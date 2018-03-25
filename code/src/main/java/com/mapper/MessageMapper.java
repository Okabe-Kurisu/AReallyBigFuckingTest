package com.mapper;

import com.model.Message;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface MessageMapper {
    @Insert({
        "insert into message (mid, user_id, ",
        "accpeter_id, date, ",
        "is_read, content)",
        "values (#{mid,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{accpeter_id,jdbcType=INTEGER}, #{date,jdbcType=INTEGER}, ",
        "#{is_read,jdbcType=BIT}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Message record);

    @Select({
        "select",
        "mid, user_id, accpeter_id, date, is_read, content",
        "from message"
    })
    @Results({
        @Result(column="mid", property="mid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="accpeter_id", property="accpeter_id", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.INTEGER),
        @Result(column="is_read", property="is_read", jdbcType=JdbcType.BIT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Message> selectAll();
}