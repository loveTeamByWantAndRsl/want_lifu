package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.UserAddressMapper;
import com.example.wantlifu.entity.UserAddress;
import com.example.wantlifu.entity.UserAddressExample;
import com.example.wantlifu.service.security.LoginEntityHelper;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.04.16.15:36
 */
@Service
public class UserAddressService {
    @Autowired
    private UserAddressMapper addressMapper;


    public Map<String,String> setDefaulted(int id, int uid){

        UserAddressExample example = new UserAddressExample();
        example.createCriteria().andDefaultedEqualTo(StaticPool.useful).andUidEqualTo(uid);
        UserAddress tempAddress = new UserAddress();
        tempAddress.setDefaulted(StaticPool.notUseful);
        int flag = addressMapper.updateByExampleSelective(tempAddress, example);

        if(flag > 0 ){

            UserAddress address = new UserAddress();
            address.setDefaulted(StaticPool.useful);
            address.setId(id);

            flag = addressMapper.updateByPrimaryKeySelective(address);
            if(flag > 0)
                return StaticPool.genSuccessRes();
            return StaticPool.genFailRes("服务繁忙，请重试");
        }
        return StaticPool.genFailRes("服务繁忙，请重试");
    }

    public Map<String,String> addAddress(UserAddress address){        int flag = addressMapper.insertSelective(address);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes("服务繁忙，请重试");
    }

    public Map<String,String> updateAddress(UserAddress address){
        int flag = addressMapper.updateByPrimaryKeySelective(address);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes("服务繁忙，请重试");
    }
    public Map<String,String> deleteAddress(int id){
        UserAddress address = new UserAddress();
        address.setStatus(StaticPool.notUseful);
        address.setId(id);
        return updateAddress(address);
    }
    public List<UserAddress> getAllUsefulAddress(int uid){
        UserAddressExample example = new UserAddressExample();
        example.createCriteria().andStatusEqualTo(StaticPool.useful).andUidEqualTo(uid);
        example.setOrderByClause("defaulted desc");
        List<UserAddress> userAddresses = addressMapper.selectByExample(example);
        return userAddresses;
    }

    public UserAddress getAddressById(int id){
        return addressMapper.selectByPrimaryKey(id);
    }

}

