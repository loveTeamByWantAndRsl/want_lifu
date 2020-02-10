package com.example.wantlifu.dao;

import com.example.wantlifu.entity.Trademark;
import com.example.wantlifu.entity.TrademarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrademarkMapper {
    long countByExample(TrademarkExample example);

    int deleteByExample(TrademarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Trademark record);

    int insertSelective(Trademark record);

    List<Trademark> selectByExample(TrademarkExample example);

    Trademark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Trademark record, @Param("example") TrademarkExample example);

    int updateByExample(@Param("record") Trademark record, @Param("example") TrademarkExample example);

    int updateByPrimaryKeySelective(Trademark record);

    int updateByPrimaryKey(Trademark record);
}