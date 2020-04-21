package com.example.wantlifu.service.impl;

import com.example.wantlifu.dao.AboutUsMapper;
import com.example.wantlifu.entity.AboutUs;
import com.example.wantlifu.entity.AboutUsExample;
import com.example.wantlifu.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.04.08.20:13
 */
@Service
public class AboutUsService {
    @Autowired
    AboutUsMapper aboutUsMapper;

    public AboutUs getAboutUs(){
        PageHelper.startPage(1,1);
        List<AboutUs> aboutUses = aboutUsMapper.selectByExample(new AboutUsExample());
        PageInfo<AboutUs> of = PageInfo.of(aboutUses);
        if( of.getList().isEmpty() ){
            int flag = 0;
            AboutUs aboutUs = new AboutUs();
            aboutUs.setPic("not");
            aboutUs.setDetail("暂无");
            while(flag == 0)
                flag = aboutUsMapper.insertSelective(aboutUs);

            return aboutUs;
        }
        return of.getList().get(0);
    }
    public Map<String,String> updateAboutUs(AboutUs aboutUs){
        if(aboutUs.getId() == null || aboutUs.getId() <= 0)
            return StaticPool.genFailRes("id 不合法！");
        int flag = aboutUsMapper.updateByPrimaryKeySelective(aboutUs);
        if(flag > 0)
            return StaticPool.genSuccessRes();
        return StaticPool.genFailRes();
    }

}
