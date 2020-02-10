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


    String ADMIN = "admin";
    String USER = "user";

    int useful = 1;
    int notUseful = 0;



    static Map<String,String> genFailRes(String message){
        HashMap<String, String> map = new HashMap<>();
        map.put(ERROR,message);
        return map;
    }
    static Map<String,String> genFailRes(){
        return genFailRes("error");
    }
    static Map<String,String> genSuccessRes(String message){
        HashMap<String, String> map = new HashMap<>();
        map.put(SUCCESS,message);
        return map;
    }
    static Map<String,String> genSuccessRes(){
        return genSuccessRes("success");
    }


    static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }
    static Date localDateTimeToDate(LocalDateTime dateTime){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = dateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }
}
