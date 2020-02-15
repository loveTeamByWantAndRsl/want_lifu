package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.CommentMapper;
import com.example.wantlifu.entity.Comment;
import com.example.wantlifu.entity.CommentExample;
import com.example.wantlifu.service.search.CommentSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品评论 服务层
 *
 * @author want
 * @createTime 2020.01.16.20:35
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 增加 评论
     * @param comment
     * @return
     */
    public Map<String,String> addComment(Comment comment){
        int flag = commentMapper.insertSelective(comment);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 删除 评论
     * @param id
     * @param userid
     * @param flag  管理员吗 ？ true is | false no
     * @return
     */
    public Map<String,String> deleteComment(int id,Integer userid,boolean flag){
        if(!flag){
            Comment comment = commentMapper.selectByPrimaryKey(id);
            if(!comment.getUserid().equals(userid) )
                return StaticPool.genFailRes();
        }
        Comment comment = new Comment();
        comment.setId(id);
        comment.setStatus(0);

        int ans = commentMapper.updateByPrimaryKeySelective(comment);
        if(ans > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 查询 评论
     * @param start
     * @param pageSize
     * @param c
     * @return
     */
    public PageInfo<Comment> selectComment(int start, int pageSize, CommentSearchEntity c){
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();

        if(c.getId() != null && c.getId() > 0 )
            criteria.andIdEqualTo(c.getId());
        if(c.getStatus() != null && c.getStatus() > 0 )
            criteria.andStatusEqualTo(c.getStatus());

//        if(c.getScore() != null && c.getScore() > 0 )
//            criteria.andScoreEqualTo(c.getScore());
        if(c.getUserId() != null && c.getUserId() > 0 )
            criteria.andUseridEqualTo(c.getUserId());
        if(c.getEntityId() != null && c.getEntityId() > 0 )
            criteria.andEntityIdEqualTo(c.getEntityId());
        if(c.getEntityType() != null && c.getEntityType() > 0 )
            criteria.andEntityTypeEqualTo(c.getEntityType());
        if(c.getFatherId() != null && c.getFatherId() > 0 )
            criteria.andFatherIdEqualTo(c.getFatherId());

        PageHelper.startPage(start,pageSize);
        List<Comment> comments = commentMapper.selectByExample(example);
        return PageInfo.of(comments);
    }


}
