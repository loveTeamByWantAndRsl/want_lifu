package com.example.wantlifu.dao;

import com.example.wantlifu.entity.Lifu;
import com.example.wantlifu.entity.LifuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifuMapper {
    long countByExample(LifuExample example);

    int deleteByExample(LifuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lifu record);

    int insertSelective(Lifu record);

    List<Lifu> selectByExampleWithBLOBs(LifuExample example);

    List<Lifu> selectByExample(LifuExample example);

    Lifu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lifu record, @Param("example") LifuExample example);

    int updateByExampleWithBLOBs(@Param("record") Lifu record, @Param("example") LifuExample example);

    int updateByExample(@Param("record") Lifu record, @Param("example") LifuExample example);

    int updateByPrimaryKeySelective(Lifu record);

    int updateByPrimaryKeyWithBLOBs(Lifu record);

    int updateByPrimaryKey(Lifu record);
}