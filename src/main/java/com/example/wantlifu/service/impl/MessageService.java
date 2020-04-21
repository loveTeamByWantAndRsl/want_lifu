package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.MessageMapper;
import com.example.wantlifu.entity.Message;
import com.example.wantlifu.entity.MessageExample;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 消息 服务 层
 *
 * @author want
 * @createTime 2020.01.16.22:05
 */
@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;

    /**
     * 发送 消息
     * @param message
     * @return
     */
    public Map<String,String> sendMessage(Message message){
        int flag = messageMapper.insertSelective(message);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

    /**
     *  查看对话
     * @param start
     * @param pageSize
     * @param userId
     * @return
     */
    public PageInfo<Message> selectMessageByUserId(int start,int pageSize,int userId){
        PageHelper.startPage(start,pageSize);
        MessageExample example = new MessageExample();
        example.or().andAcceptIdEqualTo(userId);
        example.or().andSendIdEqualTo(userId);

//        example.setOrderByClause("conversation_id");
        example.setOrderByClause("send_time desc");
        List<Message> messages = messageMapper.selectByExample(example);

        return PageInfo.of(messages);
    }
    /**
     * 查看 对话 详细
     */
    public PageInfo<Message> selectMessageByConversationId(int start,int pageSize,int conversationId){
        PageHelper.startPage(start,pageSize);
        MessageExample example = new MessageExample();
        example.createCriteria().andConversationIdEqualTo(conversationId);
        example.setOrderByClause("send_time desc");
        List<Message> messages = messageMapper.selectByExample(example);

        return PageInfo.of(messages);
    }

    /**
     * 删除 对话
     */
//    public Map<String,String> deleteConversation(int conversationId,int ){
//        MessageExample example = new MessageExample();
//        example.createCriteria().andConversationIdEqualTo(conversationId);
//        Message message = new Message();
//        message.setShowInUser(0);
//        int flag = messageMapper.updateByExampleSelective(message, example);
//        if(flag > 0)
//            return StaticPool.genSuccessRes();
//        return StaticPool.genFailRes();
//    }
}
