package com.jessie.mall.shop.Controller;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.shop.feign.FastDfsFileFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description:
 * @author: money
 * @time: 2020/7/17 23:17
 */
@RestController
@RequestMapping("/File/file")
public class Web_FastDfsFileController {

    @Resource
    private FastDfsFileFeignClient fastDfsFileFeignClient;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result upload(@RequestPart(value = "file",required = false) MultipartFile file){
        return fastDfsFileFeignClient.upload(file);
    }
}
