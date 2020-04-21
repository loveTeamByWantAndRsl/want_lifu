package com.example.wantlifu.util.redis.help;

/**
 * redis key 的 生成 util
 *
 *
 * @author want
 * @createTime 2020.02.23.12:07
 */
public class KeyUtil {
    //用户 收藏 key
    private static final String USER_PREFIX = "user_key";
    private static final String USER_ZSORT_PREFIX = "user_key";
    private static final String START_PREFIX = "start_key";
//    用户 购物车 key
    private static final String CART_PREFIX = "cart_key";
    private static final String SPLIT = "_";

    /**
     * 获取 用户的 key
     * @param uid
     * @return
     */
    public static String genUserKey(Integer uid){
        return USER_PREFIX+SPLIT+uid;
    }

    public static String genUserZSortKey(Integer uid){
        return USER_ZSORT_PREFIX+SPLIT+uid;
    }

    /**
     * 获取收藏的 key
     * @param start
     * @param entityId
     * @return
     */
    public static String genStartKey(Start start,Integer entityId){
        return USER_PREFIX+SPLIT+start.getType()+SPLIT+entityId;
    }
    public static String genUserCartKey(Integer uid){
        return CART_PREFIX+SPLIT+uid;
    }
}
