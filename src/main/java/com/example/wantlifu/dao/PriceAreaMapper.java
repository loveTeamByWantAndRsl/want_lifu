package com.example.wantlifu.dao;

import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.entity.PriceAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceAreaMapper {
    long countByExample(PriceAreaExample example);

    int deleteByExample(PriceAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PriceArea record);

    int insertSelective(PriceArea record);

    List<PriceArea> selectByExample(PriceAreaExample example);

    PriceArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PriceArea record, @Param("example") PriceAreaExample example);

    int updateByExample(@Param("record") PriceArea record, @Param("example") PriceAreaExample example);

    int updateByPrimaryKeySelective(PriceArea record);

    int updateByPrimaryKey(PriceArea record);
}