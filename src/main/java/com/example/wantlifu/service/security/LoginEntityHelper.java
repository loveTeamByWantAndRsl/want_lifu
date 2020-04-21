package com.example.wantlifu.service.security;



import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class LoginEntityHelper {



    public Object getEntity(){
        if(SecurityContextHolder.getContext().getAuthentication() != null)
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return null;
    }

    /**
     * 获取在线 的 实体，若是不对应 返回null
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getEntityByClass(Class<T> clazz){
        Object entity = getEntity();
        if(entity.getClass() == clazz)
            return clazz.cast(entity);
        else
            return null;
    }

    public OnlineEntity getOnlineEntity(){
        Object entity = getEntity();
        if(entity instanceof OnlineEntity)
            return (OnlineEntity) entity;
        else
            return null;
    }

}
