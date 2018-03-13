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
        "values (#{mid,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{accpeterId,jdbcType=INTEGER}, #{date,jdbcType=TIMESTAMP}, ",
        "#{isRead,jdbcType=BIT}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Message record);

    @Select({
        "select",
        "mid, user_id, accpeter_id, date, is_read, content",
        "from message"
    })
    @Results({
        @Result(column="mid", property="mid", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="accpeter_id", property="accpeterId", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_read", property="isRead", jdbcType=JdbcType.BIT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Message> selectAll();
}