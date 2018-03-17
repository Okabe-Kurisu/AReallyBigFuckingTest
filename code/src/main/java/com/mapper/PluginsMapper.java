package com.mapper;

import com.model.Plugins;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface PluginsMapper {
    @Insert({
        "insert into PLUGINS (PLUGIN_NAME, PLUGIN_VERSION, ",
        "PLUGIN_STATUS, PLUGIN_TYPE, ",
        "PLUGIN_TYPE_VERSION, PLUGIN_LIBRARY, ",
        "PLUGIN_LIBRARY_VERSION, PLUGIN_AUTHOR, ",
        "PLUGIN_LICENSE, LOAD_OPTION, ",
        "PLUGIN_DESCRIPTION)",
        "values (#{PLUGIN_NAME,jdbcType=VARCHAR}, #{PLUGIN_VERSION,jdbcType=VARCHAR}, ",
        "#{PLUGIN_STATUS,jdbcType=VARCHAR}, #{PLUGIN_TYPE,jdbcType=VARCHAR}, ",
        "#{PLUGIN_TYPE_VERSION,jdbcType=VARCHAR}, #{PLUGIN_LIBRARY,jdbcType=VARCHAR}, ",
        "#{PLUGIN_LIBRARY_VERSION,jdbcType=VARCHAR}, #{PLUGIN_AUTHOR,jdbcType=VARCHAR}, ",
        "#{PLUGIN_LICENSE,jdbcType=VARCHAR}, #{LOAD_OPTION,jdbcType=VARCHAR}, ",
        "#{PLUGIN_DESCRIPTION,jdbcType=LONGVARCHAR})"
    })
    int insert(Plugins record);

    @Select({
        "select",
        "PLUGIN_NAME, PLUGIN_VERSION, PLUGIN_STATUS, PLUGIN_TYPE, PLUGIN_TYPE_VERSION, ",
        "PLUGIN_LIBRARY, PLUGIN_LIBRARY_VERSION, PLUGIN_AUTHOR, PLUGIN_LICENSE, LOAD_OPTION, ",
        "PLUGIN_DESCRIPTION",
        "from PLUGINS"
    })
    @Results({
        @Result(column="PLUGIN_NAME", property="PLUGIN_NAME", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_VERSION", property="PLUGIN_VERSION", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_STATUS", property="PLUGIN_STATUS", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_TYPE", property="PLUGIN_TYPE", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_TYPE_VERSION", property="PLUGIN_TYPE_VERSION", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_LIBRARY", property="PLUGIN_LIBRARY", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_LIBRARY_VERSION", property="PLUGIN_LIBRARY_VERSION", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_AUTHOR", property="PLUGIN_AUTHOR", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_LICENSE", property="PLUGIN_LICENSE", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOAD_OPTION", property="LOAD_OPTION", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_DESCRIPTION", property="PLUGIN_DESCRIPTION", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Plugins> selectAll();
}