package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSpecificationOption;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@FeignClient("cloud-sellergoods-service")
public interface SpecificationOptionFeignClient {

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/findAll")
    public List<TbSpecificationOption> findAll();


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/findPage")
    public pageResult findPage(@RequestParam("page") int page, @RequestParam("rows")int rows);

    /**
     * 增加
     * @param specificationOption
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/add")
    public Result add(@RequestBody TbSpecificationOption specificationOption);

    /**
     * 修改
     * @param specificationOption
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/update")
    public Result update(@RequestBody TbSpecificationOption specificationOption);

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/findOne")
    public TbSpecificationOption findOne(@RequestParam("id") Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/delete")
    public Result delete(@RequestParam("ids") Long [] ids);

    /**
     * 查询+分页
     * @param specificationOption
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/SpecificationOption/specificationOption/search")
    public pageResult search(@RequestBody TbSpecificationOption specificationOption,
                             @RequestParam("page") int page,@RequestParam("rows") int rows);
    }


