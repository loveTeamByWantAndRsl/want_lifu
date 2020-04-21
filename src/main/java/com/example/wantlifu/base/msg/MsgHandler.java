package com.example.wantlifu.base.msg;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.02.19.12:14
 */
public interface MsgHandler {
    public boolean doHandler(Map<String,Object> map);
    public List<Type> getSupport();
}
