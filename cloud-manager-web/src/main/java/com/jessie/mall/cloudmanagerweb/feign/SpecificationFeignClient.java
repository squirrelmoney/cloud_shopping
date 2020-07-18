package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.R;
import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSpecification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cloud-sellergoods-service")
public interface SpecificationFeignClient {
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/Specification/specification/findAll")
    public List<TbSpecification> findAll();


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/Specification/specification/findPage")
    public pageResult  findPage(@RequestParam("page") int page,@RequestParam("rows")int rows);

    /**
     * 增加
     * @param specification
     * @return
     */
    @RequestMapping("/Specification/specification/add")
    public Result add(@RequestBody TbSpecification specification);

    /**
     * 修改
     * @param specification
     * @return
     */
    @RequestMapping("/Specification/specification/update")
    public Result update(@RequestBody TbSpecification specification);

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/Specification/specification/findOne")
    public TbSpecification findOne(@RequestParam Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/Specification/specification/delete")
    public Result delete(@RequestParam Long [] ids);

    /**
     * 查询+分页
     * @param specification
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/Specification/specification/search")
    public pageResult search(@RequestBody TbSpecification specification,@RequestParam("page") int page, @RequestParam("rows") int rows  );

    @GetMapping("/Specification/specification/forType")
    List<TypeTemplateResult> selectforType();
}
