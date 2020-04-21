package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.AboutServersMapper;
import com.example.wantlifu.entity.AboutServers;
import com.example.wantlifu.entity.AboutServersExample;
import com.example.wantlifu.service.search.AboutServiceSearcherEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.04.08.20:42
 */
@Service
public class AboutService {
    @Autowired
    AboutServersMapper aboutServersMapper;

    public PageInfo<AboutServers> selectAboutServiceByEntity(Integer start
            , Integer pageSize, AboutServiceSearcherEntity entity){
        PageHelper.startPage(start,pageSize);
        AboutServersExample example = new AboutServersExample();
        AboutServersExample.Criteria criteria = example.createCriteria();
        if( entity.getStatus() != null && entity.getStatus() >= 0)
            criteria.andStatusEqualTo(entity.getStatus());
        if(!StringUtils.isEmpty(entity.getKey()))
            criteria.andNameLike(entity.getKey()+"%");
        List<AboutServers> aboutServers = aboutServersMapper.selectByExample(example);

        return PageInfo.of(aboutServers);
    }

    public List<AboutServers> getAllUseful(){
        AboutServersExample example = new AboutServersExample();
        example.createCriteria().andStatusEqualTo(StaticPool.useful);
        List<AboutServers> aboutServers = aboutServersMapper.selectByExample(example);
        return aboutServers;
    }
    public AboutServers getById(Integer id){
        return aboutServersMapper.selectByPrimaryKey(id);
    }
    public Map<String,String> add(AboutServers aboutServers){
        int flag = aboutServersMapper.insertSelective(aboutServers);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
    public Map<String,String> update(AboutServers aboutServers) {
        int flag = aboutServersMapper.updateByPrimaryKeySelective(aboutServers);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

}
