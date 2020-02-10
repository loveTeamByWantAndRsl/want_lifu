package com.example.wantlifu.dao;

import com.example.wantlifu.entity.WtOrder;
import com.example.wantlifu.entity.WtOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WtOrderMapper {
    long countByExample(WtOrderExample example);

    int deleteByExample(WtOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WtOrder record);

    int insertSelective(WtOrder record);

    List<WtOrder> selectByExample(WtOrderExample example);

    WtOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WtOrder record, @Param("example") WtOrderExample example);

    int updateByExample(@Param("record") WtOrder record, @Param("example") WtOrderExample example);

    int updateByPrimaryKeySelective(WtOrder record);

    int updateByPrimaryKey(WtOrder record);
}