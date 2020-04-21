package com.example.wantlifu.service.impl;

import com.example.wantlifu.controller.reciveEntity.QuickCommentReciveEntity;
import com.example.wantlifu.dao.QuickCommentMapper;
import com.example.wantlifu.entity.QuickComment;
import com.example.wantlifu.entity.QuickCommentExample;
import com.example.wantlifu.exception.IceOrBack;
import com.example.wantlifu.exception.ReBackException;
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
    public QuickComment get(Integer id){
        return quickCommentMapper.selectByPrimaryKey(id);
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
    public Map<String,String> reBackQuickComment(int id){
        QuickComment comment = new QuickComment();
        comment.setId(id);
        comment.setStatus(StaticPool.useful);

        return this.updateQuickComment(comment);
    }
    /**
     * 批量 恢复价格 区间 -- > 内部实现为循环调用 reBackPriceAreaById
     * @param ids
     * @return
     */
    public Map<String,String> reBackQuickComment(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = reBackQuickComment(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new ReBackException(IceOrBack.QUICK_COMMENT);
        }
        return StaticPool.genSuccessRes();
    }
    /**
     *
     * 批量删除 价格 区间 -- > 内部实现为循环调用 deletePriceAreaById
     * @param ids
     * @return
     */
    public Map<String,String> iceQuickComment(Integer[] ids){
        for(Integer id : ids){
            Map<String, String> res = deleteQuickComment(id);
            if(res.containsKey(StaticPool.ERROR))
                throw new RuntimeException("冻结失败！！！");
        }
        return StaticPool.genSuccessRes();
    }

    public PageInfo<QuickComment> selectByEntity(QuickCommentReciveEntity entity){
        QuickCommentExample example = new QuickCommentExample();
        QuickCommentExample.Criteria criteria = example.createCriteria();

        PageHelper.startPage(entity.getStart(),entity.getPageSize());

        if(entity.getEntity().getStatus() != null && entity.getEntity().getStatus() >= 0)
            criteria.andStatusEqualTo(entity.getEntity().getStatus());
        if( !StringUtils.isEmpty(entity.getEntity().getKey()))
            criteria.andContentLike(entity.getEntity().getKey()+"%");

        List<QuickComment> quickComments = quickCommentMapper.selectByExample(example);

        return PageInfo.of(quickComments);
    }
}
