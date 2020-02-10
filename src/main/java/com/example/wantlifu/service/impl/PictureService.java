package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.PictureMapper;
import com.example.wantlifu.entity.Picture;
import com.example.wantlifu.entity.PictureExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author want
 * @createTime 2020.01.17.21:14
 *
 * 统一的 图片 服务层
 *
 */
@Service
public class PictureService {

    @Autowired
    PictureMapper pictureMapper;

    /**
     * 查找 图片 按照 实体
     *
     * @param entityId
     * @param entityType
     * @return
     */
    public List<Picture> selectPictureByEntity(Integer entityId,Integer entityType){
        PictureExample example = new PictureExample();
        example.createCriteria().andEntityIdEqualTo(entityId).andEntityTypeEqualTo(entityType);

        return pictureMapper.selectByExample(example);
    }

    /**
     * 删除 图片
     * @param id
     * @return
     */
    public boolean deletePic(Integer id){
        Picture picture = new Picture();
        picture.setId(id);
        picture.setStatus(0);
        return pictureMapper.updateByPrimaryKeySelective(picture) > 0;
    }


}
