package com.example.wantlifu.dao;

import com.example.wantlifu.entity.LifuType;
import com.example.wantlifu.entity.LifuTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifuTypeMapper {
    long countByExample(LifuTypeExample example);

    int deleteByExample(LifuTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LifuType record);

    int insertSelective(LifuType record);

    List<LifuType> selectByExample(LifuTypeExample example);

    LifuType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LifuType record, @Param("example") LifuTypeExample example);

    int updateByExample(@Param("record") LifuType record, @Param("example") LifuTypeExample example);

    int updateByPrimaryKeySelective(LifuType record);

    int updateByPrimaryKey(LifuType record);
}