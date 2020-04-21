package com.example.wantlifu.web.api;


import com.example.wantlifu.base.ApiResponse;
import com.example.wantlifu.base.ApiResponseFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 王志坚
 * @createTime 2019.11.27.19:57
 */
@Controller
public class ImageUploadController {

    @PostMapping("upload")
    @ResponseBody
    public ApiResponse upload(HttpServletRequest request, MultipartFile file){
        String realPath = this.getClass().getClassLoader().getResource("static").getFile().toString()+File.separator+"upload"+File.separator;
        System.out.println("realPath = " + realPath);
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        String originalFilename = file.getOriginalFilename();
        //originalFilename = originalFilename.substring(originalFilename.lastIndexOf("."));
        name += originalFilename;
        System.out.println("originalFilename = " + originalFilename);
        File f = new File(realPath+name);
        File parentFile = f.getParentFile();
        if( !parentFile.exists())
            parentFile.mkdirs();
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        URLDecoder
        return ApiResponseFactory.genSuccessApiResponse("/upload/"+name);
    }

    @PostMapping("upload2")
    @ResponseBody
    public ApiResponse upload2(HttpServletRequest request, MultipartFile file){
        ApiResponse upload = upload(request, file);
        Map<String,String> res = new HashMap<>();
        res.put("src",upload.getMessage());
        ApiResponse apiResponse = ApiResponseFactory.genSuccessApiResponse(res);
        apiResponse.setCode(0);
        return apiResponse;
    }

}
