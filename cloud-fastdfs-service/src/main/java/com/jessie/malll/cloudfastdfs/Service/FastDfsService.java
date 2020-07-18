package com.jessie.malll.cloudfastdfs.Service;

import com.jessie.mall.common.common.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: money
 * @time: 2020/7/17 17:20
 */
public interface FastDfsService {
     Result upload(MultipartFile file);
     void download(String path, String filename);

}
