package com.example.wantlifu.base.msg;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 删除 sku的  适配类
 * @author want
 * @createTime 2020.02.19.13:32
 */
@Component
public class DeletedSKUHandler implements MsgHandler{
    @Override
    public boolean doHandler(Map<String, Object> map) {
        return false;
    }

    @Override
    public List<Type> getSupport() {
        return Arrays.asList(Type.DSKU);
    }
}
