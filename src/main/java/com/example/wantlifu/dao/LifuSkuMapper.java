package com.example.wantlifu.dao;

import com.example.wantlifu.entity.LifuSku;
import com.example.wantlifu.entity.LifuSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LifuSkuMapper {
    long countByExample(LifuSkuExample example);

    int deleteByExample(LifuSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LifuSku record);

    int insertSelective(LifuSku record);

    List<LifuSku> selectByExample(LifuSkuExample example);

    LifuSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LifuSku record, @Param("example") LifuSkuExample example);

    int updateByExample(@Param("record") LifuSku record, @Param("example") LifuSkuExample example);

    int updateByPrimaryKeySelective(LifuSku record);

    int updateByPrimaryKey(LifuSku record);
}