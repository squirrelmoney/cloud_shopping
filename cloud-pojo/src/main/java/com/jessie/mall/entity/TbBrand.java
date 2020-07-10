package com.jessie.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (TbBrand)实体类
 *
 * @author makejava
 * @since 2020-07-07 14:11:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TbBrand implements Serializable {
    private static final long serialVersionUID = 378266428198600676L;
    
    private Long id;
    /**
    * 品牌名称
    */
    private String name;
    /**
    * 品牌首字母
    */
    private String firstChar;



}