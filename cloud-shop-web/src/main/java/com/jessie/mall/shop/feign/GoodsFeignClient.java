package com.jessie.mall.shop.feign;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.model.Goods;
import com.jessie.mall.pojo.TbGoods;
import com.jessie.mall.pojo.TbItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/16 15:28
 */
@FeignClient("cloud-sellergoods-service")
 public interface GoodsFeignClient {
    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/Goods/goods/findAll")
    List<TbGoods> findAll();


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/Goods/goods/findPage")
    pageResult findPage(@RequestParam("page") int page, @RequestParam("rows") int rows);


    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @RequestMapping("/Goods/goods/update")
    Result update(@RequestBody TbGoods goods);


    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/Goods/goods/findOne")
    TbGoods findOne(@RequestParam Long id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/Goods/goods/delete")
    Result delete(@RequestParam Long[] ids);

    /**
     * 查询+分页
     *
     * @param goods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/Goods/goods/search")
    pageResult search(@RequestBody TbGoods goods, @RequestParam("page") int page, @RequestParam("rows") int rows);


   /**
    * 增加
    *
    * @param goods
    * @return
    */
   @RequestMapping("/Goods/goods/add")
   Result add(@RequestBody Goods goods, @RequestParam("sellerId") String sellerId);


   /**
    * 根据上级ID返回列表
    * @return
    */
   @RequestMapping("/ItemCat/itemCat/findOnlyByParentId")
    List<TbItemCat> findOnlyByParentId(@RequestParam("parentId") Long parentId);

}