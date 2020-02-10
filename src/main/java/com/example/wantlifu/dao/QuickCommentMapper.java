package com.example.wantlifu.dao;

import com.example.wantlifu.entity.QuickComment;
import com.example.wantlifu.entity.QuickCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuickCommentMapper {
    long countByExample(QuickCommentExample example);

    int deleteByExample(QuickCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuickComment record);

    int insertSelective(QuickComment record);

    List<QuickComment> selectByExample(QuickCommentExample example);

    QuickComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuickComment record, @Param("example") QuickCommentExample example);

    int updateByExample(@Param("record") QuickComment record, @Param("example") QuickCommentExample example);

    int updateByPrimaryKeySelective(QuickComment record);

    int updateByPrimaryKey(QuickComment record);
}