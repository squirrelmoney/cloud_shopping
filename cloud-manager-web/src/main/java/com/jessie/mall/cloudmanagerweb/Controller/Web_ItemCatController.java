package com.jessie.mall.cloudmanagerweb.Controller;

import com.jessie.mall.cloudmanagerweb.feign.ItemCatFeignClient;
import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo .TbItemCat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/15 22:41
 */
@RestController
@RequestMapping("/ItemCat/itemCat")
public class Web_ItemCatController {

        @Resource
        private ItemCatFeignClient itemCatFeignClient;

        /**
         * 返回全部列表
         * @return
         */
        @RequestMapping("/findAll")
        public List<TbItemCat> findAll(){
            return itemCatFeignClient.findAll();
        }


        /**
         * 返回全部列表
         * @return
         */
        @RequestMapping("/findPage")
        public pageResult findPage(@RequestParam("page") int page,@RequestParam("rows") int rows){
            return itemCatFeignClient.findPage(page, rows);
        }

        /**
         * 增加
         * @param itemCat
         * @return
         */
        @RequestMapping("/add")
        public Result add(@RequestBody TbItemCat itemCat){
            return itemCatFeignClient.add(itemCat);
        }

        /**
         * 修改
         * @param itemCat
         * @return
         */
        @RequestMapping("/update")
        public Result update(@RequestBody TbItemCat itemCat){
            return    itemCatFeignClient.update(itemCat);
        }

        /**
         * 获取实体
         * @param id
         * @return
         */
        @RequestMapping("/findOne")
        public TbItemCat findOne(@RequestParam("id") Long id){
            return itemCatFeignClient.findOne(id);
        }

        /**
         * 批量删除
         * @param ids
         * @return
         */
        @RequestMapping("/delete")
        public Result delete(@RequestParam("ids") Long [] ids){
            return  itemCatFeignClient.delete(ids);
        }

        /**
         * 查询+分页
         * @param itemCat
         * @param page
         * @param rows
         * @return
         */
        @RequestMapping("/search")
        pageResult search(@RequestBody TbItemCat itemCat, @RequestParam("page") int page, @RequestParam("rows") int rows  ){
            return itemCatFeignClient.search(itemCat, page, rows);
        }

        /**
         * 根据上级ID查询列表
         * @param parentId
         * @return
         */
        @RequestMapping("/findByParentId")
        public pageResult findByParentId(Long parentId, @RequestParam("page") int page, @RequestParam("rows") int rows){
                return itemCatFeignClient.findByParentId(parentId, page, rows);
        }

}
