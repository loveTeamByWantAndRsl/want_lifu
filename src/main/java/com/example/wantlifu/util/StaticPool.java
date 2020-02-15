package com.example.wantlifu.util;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.10.21:43
 */
public interface StaticPool {

     String ERROR = "error";
     String SUCCESS = "success";


    /**
     * 角色的 admin 字符代表
     */
    String ADMIN = "admin";
    /**
     * 角色的 user 字符代表
     */
    String USER = "user";

    /**
     * 数据库的 有效状态
     */
    int useful = 1;
    /**
     *  数据库的 无效状态
     */
    int notUseful = 0;


    /**
     * 根据message 生成 对应的 Map，以 error 为 key ， message 为value
     * @param message
     * @return
     */
    static Map<String,String> genFailRes(String message){
        HashMap<String, String> map = new HashMap<>();
        map.put(ERROR,message);
        return map;
    }

    /**
     * 生成 对应的 Map，以 error 为 key ， error 为value ， 无参的
     * @return
     */
    static Map<String,String> genFailRes(){
        return genFailRes("error");
    }

    /**
     * 根据message 生成 对应的 Map，以 success 为 key ， message 为value
     * @param message
     * @return
     */
    static Map<String,String> genSuccessRes(String message){
        HashMap<String, String> map = new HashMap<>();
        map.put(SUCCESS,message);
        return map;
    }
    /**
     * 生成 对应的 Map，以 error 为 key ， error 为value ， 无参的
     * @return
     */
    static Map<String,String> genSuccessRes(){
        return genSuccessRes("success");
    }

    /**
     * date 与 localDateTime 的 转换方法
     * @param date
     * @return
     */
    static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * localDateTime 与 date 的 转换方法
     * @param dateTime
     * @return
     */
    static Date localDateTimeToDate(LocalDateTime dateTime){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = dateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }
}
