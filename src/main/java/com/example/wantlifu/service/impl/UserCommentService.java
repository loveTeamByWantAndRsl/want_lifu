package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.UserCommentMapper;
import com.example.wantlifu.entity.UserComment;
import com.example.wantlifu.entity.UserCommentExample;
import com.example.wantlifu.service.search.UserCommentSearchEntity;
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
 * @createTime 2020.02.06.10:54
 *
 *
 * 类博客 的 服务层
 */
@Service
public class UserCommentService {

    @Autowired
    private UserCommentMapper userCommentMapper;

    /**
     * 增加 博客
     * @param userComment
     * @return
     */
    public Map<String,String> addBlog(UserComment userComment){
        // 还需 确认 必须要有 购买经历
        int flag = userCommentMapper.insertSelective(userComment);

        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 查询博客
     * @param start
     * @param pageSize
     * @param entity
     * @return
     */
    public PageInfo<UserComment> selectBlogByEntity(int start,int pageSize,UserCommentSearchEntity entity){
        UserCommentExample example = new UserCommentExample();
        UserCommentExample.Criteria criteria = example.createCriteria();
        if( !StringUtils.isEmpty(entity.getTitle()))
            criteria.andTitleLike(entity.getTitle());
        if( entity.getStatus()!=null && entity.getStatus() >=0)
            criteria.andStatusEqualTo(entity.getStatus());
        example.setOrderByClause(entity.getOrderByKey()+entity.getOrderType());
        PageHelper.startPage(start,pageSize);

        List<UserComment> userComments = userCommentMapper.selectByExample(example);
        return PageInfo.of(userComments);
    }

    /**
     * 修改 博客
     * @param userComment
     * @return
     */
    public Map<String,String> updateBlog(UserComment userComment,int userId){
        UserComment temp = userCommentMapper.selectByPrimaryKey(userComment.getId());
        if(temp.getUserId() != userId)
            StaticPool.genFailRes("操作错误！");
        int flag = userCommentMapper.updateByPrimaryKeySelective(userComment);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     * 删除 博客
     * @param id
     * @param userId
     * @return
     */
    public Map<String,String> deleteBlog(int id,int userId){
        UserComment userComment = new UserComment();
        userComment.setId(id);
        userComment.setStatus(StaticPool.notUseful);
        return updateBlog(userComment,userId);
    }
    /**
     * 删除 博客  -- for admin
     * @param id
     * @return
     */
    public Map<String,String> deleteBlog(int id){
        UserComment userComment = new UserComment();
        userComment.setId(id);
        userComment.setStatus(StaticPool.notUseful);
        int flag = userCommentMapper.updateByPrimaryKeySelective(userComment);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }
}
