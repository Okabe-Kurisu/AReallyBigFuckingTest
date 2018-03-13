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
        "values (#{pluginName,jdbcType=VARCHAR}, #{pluginVersion,jdbcType=VARCHAR}, ",
        "#{pluginStatus,jdbcType=VARCHAR}, #{pluginType,jdbcType=VARCHAR}, ",
        "#{pluginTypeVersion,jdbcType=VARCHAR}, #{pluginLibrary,jdbcType=VARCHAR}, ",
        "#{pluginLibraryVersion,jdbcType=VARCHAR}, #{pluginAuthor,jdbcType=VARCHAR}, ",
        "#{pluginLicense,jdbcType=VARCHAR}, #{loadOption,jdbcType=VARCHAR}, ",
        "#{pluginDescription,jdbcType=LONGVARCHAR})"
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
        @Result(column="PLUGIN_NAME", property="pluginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_VERSION", property="pluginVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_STATUS", property="pluginStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_TYPE", property="pluginType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_TYPE_VERSION", property="pluginTypeVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_LIBRARY", property="pluginLibrary", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_LIBRARY_VERSION", property="pluginLibraryVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_AUTHOR", property="pluginAuthor", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_LICENSE", property="pluginLicense", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOAD_OPTION", property="loadOption", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLUGIN_DESCRIPTION", property="pluginDescription", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Plugins> selectAll();
}