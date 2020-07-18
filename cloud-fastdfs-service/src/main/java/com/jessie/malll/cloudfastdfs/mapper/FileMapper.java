package com.jessie.malll.cloudfastdfs.mapper;

import com.jessie.mall.file.Fastfile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: money
 * @time: 2020/7/17 20:47
 */
@Mapper
public interface FileMapper {

    @Insert("insert into fastdfsFile(server,name,groupName,path,createTime) " +
            "values(#{file.server},#{file.name},#{file.groupName},#{file.path},#{file.createTime})")
    int add(@Param("file") Fastfile file);
}
