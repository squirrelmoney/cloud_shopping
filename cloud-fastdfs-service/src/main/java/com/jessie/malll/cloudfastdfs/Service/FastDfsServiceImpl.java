package com.jessie.malll.cloudfastdfs.Service;
import com.jessie.mall.common.common.Result;
import com.jessie.mall.file.Fastfile;
import com.jessie.malll.cloudfastdfs.mapper.FileMapper;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * @description:
 * @author: money
 * @time: 2020/7/17 17:28
 */
@Service
public class FastDfsServiceImpl implements FastDfsService{
    @Resource
    private FastFileStorageClient fastFileStorageClient;
    @Resource
    private FileMapper fileMapper;

    @Value("${fdfsFile.groupname}")
    private String groupName;
    @Value("${spring.application.name}")
    private String servername;
    @Value("${nginx.server}")
    private String nginxServer;
    /**
     * 上传
     * @param file
     * @return
     */
    @Override
    public Result upload(MultipartFile file) {
        // 获取文件
        StorePath storePath = null;
        try {
            // 设置文件信息
            String filename=file.getOriginalFilename();
            String extend= FilenameUtils.getExtension(filename);
            storePath= fastFileStorageClient.uploadFile(groupName,file.getBytes(),extend);
            int add = fileMapper.add(new Fastfile(filename, "http://" + servername, groupName, nginxServer+storePath.getFullPath(), new Date()));
            System.out.println(storePath.getFullPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result(true,nginxServer+storePath.getFullPath());
    }

    @Override
    public void download(String path, String filename) {

    }
}
