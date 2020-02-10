package com.example.wantlifu.service.search;



import com.example.wantlifu.dao.PriceAreaMapper;
import com.example.wantlifu.entity.PriceArea;
import com.example.wantlifu.entity.PriceAreaExample;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 初始化在 mybatis的 config中
 *
 * @createTime 2019.12.17.22:37
 */
public class RentValueBlock {
    //租聘 价格区间
    public Map<String, RentValueBlock> zuPinPriceArea;
    //定制 价格区间
    public Map<String, RentValueBlock> dinZhiPriceArea;

    private static final int ZU_PIN_FLAG = 1;
    private static final int DIN_ZHI_FLAG = 1;

    public static final RentValueBlock ALL = new RentValueBlock("*",-1,-1);


    /**
     * 初始化
     */
    public RentValueBlock(PriceAreaMapper priceAreaMapper){

        PriceAreaExample example = new PriceAreaExample();
        example.createCriteria().andTypeEqualTo(ZU_PIN_FLAG).andStatusEqualTo(StaticPool.useful);
        List<PriceArea> priceAreas = priceAreaMapper.selectByExample(example);
        zuPinPriceArea = priceAreas.stream().collect(Collectors.toMap(PriceArea::getExpress
                ,priceArea -> new RentValueBlock(priceArea.getExpress(),priceArea.getMin(),priceArea.getMax())
                ,(key1,key2)->key1));

        example = new PriceAreaExample();
        example.createCriteria().andTypeEqualTo(DIN_ZHI_FLAG).andStatusEqualTo(StaticPool.useful);
        priceAreas = priceAreaMapper.selectByExample(example);
        dinZhiPriceArea = priceAreas.stream().collect(Collectors.toMap(PriceArea::getExpress
                ,priceArea -> new RentValueBlock(priceArea.getExpress(),priceArea.getMin(),priceArea.getMax())
                ,(key1,key2)->key1));
    }

    public RentValueBlock(String key, int min, int max) {
        this.key = key;
        this.max = max;
        this.min = min;
    }

    private String key;
    private Integer max;
    private Integer min;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public RentValueBlock getZuPinRentValueBlock(String key){
        RentValueBlock res = zuPinPriceArea.get(key);
        return res == null ? ALL : res;
    }
    public RentValueBlock getDinZhiRentValueBlock(String key){
        RentValueBlock res = dinZhiPriceArea.get(key);
        return res == null ? ALL : res;
    }
    public RentValueBlock getRentValueBlock(int type,String key){
        switch (type){
            case 1:
                return getZuPinRentValueBlock(key);
            case 2:
                return getDinZhiRentValueBlock(key);
            default:
                return ALL;
        }
    }

}
