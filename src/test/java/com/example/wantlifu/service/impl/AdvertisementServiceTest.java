package com.example.wantlifu.service.impl;

import com.example.wantlifu.entity.Advertising;
import com.example.wantlifu.service.search.AdvertSearchEntity;
import com.example.wantlifu.util.StaticPool;
import com.example.wantlifu.util.UUIDUtils;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author want
 * @createTime 2020.01.16.20:06
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertisementServiceTest {

    @Autowired
    AdvertisementService advertisementService;

    @Test
    public void addAdvert() {
        for (int i = 0; i < 10; i++) {
            Advertising advertising = new Advertising();
            advertising.setStatus(1);
            advertising.setPic(UUIDUtils.genStr(10));
            advertising.setUserPhone("18216308307");
            advertising.setTitle(UUIDUtils.genStr(10));
            advertising.setText(UUIDUtils.genStr(10));
            Date now = new Date();
            advertising.setStartTime(now);
            advertising.setEndTime(StaticPool
                    .localDateTimeToDate(StaticPool
                            .dateToLocalDateTime(now)
                            .plus(30, ChronoUnit.DAYS)));
            advertising.setUsername(UUIDUtils.genStr(5));
            advertisementService.addAdvert(advertising);
        }

    }

    @Test
    public void addAdvertTime() {

        Map<String, String> map = advertisementService.addAdvertTime(30, TimeUnit.DAYS, 1);
        assertNotNull(map
                .get(StaticPool.SUCCESS));
    }

    @Test
    public void deleteAdvert() {
        Map<String, String> map = advertisementService.deleteAdvert(2);
        assertNotNull(map
                .get(StaticPool.SUCCESS));
    }

    @Test
    public void updateAdvert() {
        Advertising advertising = new Advertising();
        advertising.setId(1);
        advertising.setUsername("want");
        Map<String, String> map = advertisementService.updateAdvert(advertising);
        assertNotNull(map
                .get(StaticPool.SUCCESS));
    }

    @Test
    public void selectAdvert() {
        PageInfo<Advertising> res = advertisementService.selectAdvert(2, 3, new AdvertSearchEntity());
        assertNotNull(res.getList());
    }

    @Test
    public void selectAdvertById() {
        Advertising advertising = advertisementService.selectAdvertById(1);
        assertNotNull(advertising);
    }

    @Test
    public void testDeleteAdvert() {
        Map<String, String> map = advertisementService.deleteAdvert(Arrays.asList(3, 4, 5));
        assertNotNull(map
                .get(StaticPool.SUCCESS));
    }
}