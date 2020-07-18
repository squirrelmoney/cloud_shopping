package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("cloud-sellergoods-service")
public interface ItemCatFeignClient {
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/findAll")
     List<TbItemCat> findAll();


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/findPage")
     pageResult findPage( @RequestParam("page") int page, @RequestParam("rows") int rows);

    /**
     * 增加
     * @param itemCat
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/add")
    public Result add(@RequestBody TbItemCat itemCat);

    /**
     * 修改
     * @param itemCat
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/update")
    public Result update(@RequestBody TbItemCat itemCat);

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/findOne")
    public TbItemCat findOne( @RequestParam("id") Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/delete")
    public Result delete( @RequestParam("ids") Long [] ids);

    /**
     * 查询+分页
     * @param itemCat
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/search")
     pageResult search(@RequestBody TbItemCat itemCat, @RequestParam("page") int page, @RequestParam("rows") int rows  );

    /**
     * 根据上级ID查询列表
     * @param parentId
     * @return
     */
    @RequestMapping("/ItemCat/itemCat/findByParentId")
    pageResult findByParentId(@RequestParam("parentId") Long parentId,@RequestParam("page") int page, @RequestParam("rows") int rows);
}
