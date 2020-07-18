package com.jessie.mall.model;

import com.jessie.mall.pojo.TbGoods;
import com.jessie.mall.pojo.TbGoodsDesc;
import com.jessie.mall.pojo.TbItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/16 16:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private TbGoods goods;//商品SPU
    private TbGoodsDesc goodsDesc;//商品扩展
    private List<TbItem> itemList;//商品SKU列表
}
