package com.jessie.malll.cloudfastdfs.Controller;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.file.Fastfile;
import com.jessie.malll.cloudfastdfs.Service.FastDfsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description:
 * @author: money
 * @time: 2020/7/17 22:04
 */
@RestController
@RequestMapping("/File/file")
public class FastdfsFileController {
    @Resource
    private FastDfsService fastDfsService;

    @RequestMapping("/upload")
    public Result upload(@RequestPart(value = "file",required = false) MultipartFile file){
        return fastDfsService.upload(file);
    }
}
