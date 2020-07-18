/*
package com.jessie.malll.cloudfastdfs;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.cms.MetaData;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @description:
 * @author: money
 * @time: 2020/7/17 17:14
 *//*

@Component
public class FastdfsUtils {
    public static final String DEFAULT_CHARSET = "UTF-8";

    @Resource
    private FastFileStorageClient fastFileStorageClient;

    */
/**
     * 上传
     * @param file
     * @return
     * @throws IOException
     *//*

    public StorePath upload(MultipartFile file) throws IOException {
        // 设置文件信息
        Set<MetaData> mataData = new HashSet<>();
        mataData.add(new MetaData("author", "fastdfs"));
        mataData.add(new MetaData("description",file.getOriginalFilename()));
        // 上传
        StorePath storePath = fastFileStorageClient.uploadFile(
                file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()),
                null);
        return storePath;
    }

    */
/**
     * 删除
     * @param path
     *//*

    public void delete(String path) {
        fastFileStorageClient.deleteFile(path);
    }

    */
/**
     * 删除
     * @param group
     * @param path
     *//*

    public void delete(String group,String path) {
        fastFileStorageClient.deleteFile(group,path);
    }

    */
/**
     * 文件下载
     * @param path 文件路径，例如：/group1/path=M00/00/00/itstyle.png
     * @param filename 下载的文件命名
     * @return
     *//*

    public void download(String path, String filename, HttpServletResponse response) throws IOException {
        // 获取文件
        StorePath storePath = StorePath.parseFromUrl(path);
        if (StringUtils.isBlank(filename)) {
            filename = FilenameUtils.getName(storePath.getPath());
        }
        byte[] bytes = fastFileStorageClient.downloadFile(storePath.getGroup(), storePath.getPath(), new DownloadByteArray());
        response.reset();
        response.setContentType("applicatoin/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.close();
    }
}
*/
