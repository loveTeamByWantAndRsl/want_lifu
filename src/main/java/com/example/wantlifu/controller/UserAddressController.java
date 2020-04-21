package com.example.wantlifu.controller;

import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import com.example.wantlifu.entity.TbArea;
import com.example.wantlifu.entity.UserAddress;
import com.example.wantlifu.service.impl.TbAreaServiceImpl;
import com.example.wantlifu.service.impl.UserAddressService;
import com.example.wantlifu.service.security.LoginEntityHelper;
import com.example.wantlifu.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author want
 * @createTime 2020.04.16.22:31
 */
@Controller
public class UserAddressController {
    @Autowired
    UserAddressService addressService;
    @Autowired
    LoginEntityHelper loginEntityHelper;
    @Autowired
    TbAreaServiceImpl tbAreaService;

    /**
     * 地址下拉框级联
     * @param parentId
     * @return
     */
    @RequestMapping("Area_list")
    @ResponseBody
    public ApiResponse Area_list(@RequestParam(value = "parentId",defaultValue = "100000")Integer parentId){
        List<TbArea> tbAreas = tbAreaService.queryTbAreabyParentId(parentId);
        return ApiResponseFactory.genSuccessApiResponse(tbAreas);
    }
    @ResponseBody
    @RequestMapping("/user/getAllAddress")
    public ApiResponse getAllUsefulAddress(){
        Integer id = loginEntityHelper.getOnlineEntity().getId();
        List<UserAddress> allUsefulAddress = addressService.getAllUsefulAddress(id);
        return ApiResponseFactory.genSuccessApiResponse(allUsefulAddress);
    }
    @RequestMapping("/user/delAddress")
    public String delAddress(Integer id, HttpServletResponse response) throws IOException {
        Map<String, String> map = addressService.deleteAddress(id);
        if( map.containsKey(StaticPool.SUCCESS))
            response.sendRedirect("/user/myAddress");
        return "500";
    }
    @RequestMapping("/user/addAddress")
    public String addAddress( UserAddress address, HttpServletResponse response) throws IOException {
        address.setUid(loginEntityHelper.getOnlineEntity().getId());
        Map<String, String> map = addressService.addAddress(address);
        if( map.containsKey(StaticPool.SUCCESS))
            response.sendRedirect("/user/myAddress");
        return "500";
    }
    @RequestMapping("/user/updateAddress")
    public String updateAddress(UserAddress address, HttpServletResponse response) throws IOException {
        Map<String, String> map = addressService.updateAddress(address);
        if( map.containsKey(StaticPool.SUCCESS))
            response.sendRedirect("/user/myAddress");
        return "500";
    }
    @RequestMapping("/user/setAddressDefaulted")
    public String setAddressDefaulted(Integer id, HttpServletResponse response) throws IOException {
        Integer uid = loginEntityHelper.getOnlineEntity().getId();
        Map<String, String> map = addressService.setDefaulted(id, uid);
        if( map.containsKey(StaticPool.SUCCESS))
            response.sendRedirect("/user/myAddress");
        return "500";
    }
}
