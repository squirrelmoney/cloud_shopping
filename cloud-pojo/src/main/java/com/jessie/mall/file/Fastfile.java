package com.jessie.mall.file;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @description:
 * @author: money
 * @time: 2020/7/17 17:29
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Fastfile {
    private Long id;
    private String name;
    private String server;
    private String groupName;
    private String path;
    private Date createTime;

    public Fastfile(String name, String server, String groupName, String path, Date createTime) {
        this.name = name;
        this.server = server;
        this.groupName = groupName;
        this.path = path;
        this.createTime = createTime;
    }
}
