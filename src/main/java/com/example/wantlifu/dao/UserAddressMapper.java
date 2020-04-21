package com.example.wantlifu.dao;

import com.example.wantlifu.entity.UserAddress;
import com.example.wantlifu.entity.UserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressMapper {
    long countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressExample example);

    UserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);
}