package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.QuickCommentMapper;
import com.example.wantlifu.entity.QuickComment;
import com.example.wantlifu.entity.QuickCommentExample;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.06.10:29
 *
 *
 * 快速回复服务层
 */
@Service
public class QuickCommentService {

    @Autowired
    QuickCommentMapper quickCommentMapper;

    /**
     * 添加 快速 评论
     * @param comment
     * @return
     */
    public Map<String,String> addQuickComment(QuickComment comment){
        //查找 内容 是否 重复  --- 》 考虑性能较差 -- 》 不予添加
//        QuickCommentExample example = new QuickCommentExample();
//        example.createCriteria().andContentEqualTo(comment.getContent());

        int flag = quickCommentMapper.insertSelective(comment);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 修改 快速 评论
     * @param comment
     * @return
     */
    public Map<String,String> updateQuickComment(QuickComment comment){
        int flag = quickCommentMapper.updateByPrimaryKeySelective(comment);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
    public Map<String,String> deleteQuickComment(int id){
        QuickComment comment = new QuickComment();
        comment.setId(id);
        comment.setStatus(StaticPool.notUseful);

        return this.updateQuickComment(comment);

    }
}
