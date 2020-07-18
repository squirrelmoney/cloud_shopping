package com.jessie.mall.shop.Controller;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.model.Goods;
import com.jessie.mall.pojo.TbGoods;
import com.jessie.mall.pojo.TbItemCat;
import com.jessie.mall.shop.feign.FastDfsFileFeignClient;
import com.jessie.mall.shop.feign.GoodsFeignClient;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/16 15:27
 */
@RestController
@RequestMapping("/Goods/goods")
public class Web_GoodsController {

    @Resource
    private GoodsFeignClient goodsFeignClient;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbGoods> findAll() {
        return goodsFeignClient.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public pageResult findPage( @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return goodsFeignClient.findPage(page, rows);
    }



    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbGoods goods) {
            return  goodsFeignClient.update(goods);
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbGoods findOne(@RequestParam Long id) {
        return goodsFeignClient.findOne(id);

    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestParam Long[] ids) {
        return goodsFeignClient.delete(ids);
    }

    /**
     * 查询+分页
     *
     * @param goods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public pageResult search(@RequestBody TbGoods goods, @RequestParam("page") int page, @RequestParam("rows") int rows) {
        return goodsFeignClient.search(goods, page, rows);
    }
    /**
     * 增加
     *
     * @param goods
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return  goodsFeignClient.add(goods,sellerId);
    }

    @RequestMapping("/findOnlyByParentId")
    List<TbItemCat> findByParentId(@RequestParam("parentId") Long parentId){
        return  goodsFeignClient.findOnlyByParentId(parentId);
    }


}