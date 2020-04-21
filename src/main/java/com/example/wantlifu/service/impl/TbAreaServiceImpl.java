package com.example.wantlifu.service.impl;


import com.example.wantlifu.dao.TbAreaMapper;
import com.example.wantlifu.entity.TbArea;
import com.example.wantlifu.entity.TbAreaExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbAreaServiceImpl{

    Logger logger = LoggerFactory.getLogger(TbAreaServiceImpl.class);

    @Autowired
    TbAreaMapper tbAreaMapper;


    /**
     * 通过上级的id查询地址
     * @param parentId
     * @return
     */
    public List<TbArea> queryTbAreabyParentId(Integer parentId) {
        if (parentId==null){
            logger.warn("查询地址失败，parentid不能为空");
            return null;
        }
        TbAreaExample example = new TbAreaExample();
        example.or().andParentidEqualTo(parentId);
        List<TbArea> tbAreas = tbAreaMapper.selectByExample(example);
        if (tbAreas.isEmpty()){
            return null;
        }
        return tbAreas;
    }
}
