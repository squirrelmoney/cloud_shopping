package com.jessie.mall.shop.feign;

import com.jessie.mall.common.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@FeignClient("cloud-fastdfs-service")
public interface FastDfsFileFeignClient {
    @PostMapping(value = "/File/file/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result upload(@RequestPart(value = "file",required = false) MultipartFile file);
}
