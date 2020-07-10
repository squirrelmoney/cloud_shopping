package com.jessie.mall.common.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/8 9:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class pageResult implements Serializable {
   private  long pageSize;
   private List pageNum;
}
