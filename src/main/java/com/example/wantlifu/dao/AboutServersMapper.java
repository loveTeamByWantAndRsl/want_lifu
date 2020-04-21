package com.example.wantlifu.dao;

import com.example.wantlifu.entity.AboutServers;
import com.example.wantlifu.entity.AboutServersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutServersMapper {
    long countByExample(AboutServersExample example);

    int deleteByExample(AboutServersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AboutServers record);

    int insertSelective(AboutServers record);

    List<AboutServers> selectByExample(AboutServersExample example);

    AboutServers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AboutServers record, @Param("example") AboutServersExample example);

    int updateByExample(@Param("record") AboutServers record, @Param("example") AboutServersExample example);

    int updateByPrimaryKeySelective(AboutServers record);

    int updateByPrimaryKey(AboutServers record);
}