package com.example.wantlifu.base.msg;

import com.example.wantlifu.service.impl.LifuService;
import com.example.wantlifu.service.impl.TrademarkService;
import com.example.wantlifu.util.StaticPool;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 删除礼服的 适配类
 *
 * @author want
 * @createTime 2020.02.19.12:16
 */
@Component
public class DeletedLifuHandler implements MsgHandler {
    @Autowired
    LifuService lifuService;
    @Autowired
    MsgProduce msgProduce;

    @Override
    public boolean doHandler(Map<String, Object> map) {
        Integer tid = Integer.valueOf(map.get("tid").toString());
        Map<String, String> res = lifuService.updateLifuByTardemarkDeleted(tid);
        if(res.containsKey(StaticPool.ERROR)){
            msgProduce.pushEvent(map);
            return false;
        }
        return true;
    }

    @Override
    public List<Type> getSupport() {
        return Arrays.asList(Type.DLIFU);
    }
}
