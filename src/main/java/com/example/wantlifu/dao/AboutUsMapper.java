package com.example.wantlifu.dao;

import com.example.wantlifu.entity.AboutUs;
import com.example.wantlifu.entity.AboutUsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutUsMapper {
    long countByExample(AboutUsExample example);

    int deleteByExample(AboutUsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AboutUs record);

    int insertSelective(AboutUs record);

    List<AboutUs> selectByExample(AboutUsExample example);

    AboutUs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AboutUs record, @Param("example") AboutUsExample example);

    int updateByExample(@Param("record") AboutUs record, @Param("example") AboutUsExample example);

    int updateByPrimaryKeySelective(AboutUs record);

    int updateByPrimaryKey(AboutUs record);
}