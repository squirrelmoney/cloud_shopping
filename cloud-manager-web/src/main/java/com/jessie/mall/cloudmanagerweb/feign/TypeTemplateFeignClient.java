package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbTypeTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("cloud-sellergoods-service")
public interface TypeTemplateFeignClient {
    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll();


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("TypeTemplate/typeTemplate/findPage")
    public pageResult findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);

    /**
     * 增加
     *
     * @param typeTemplate
     * @return
     */
    @RequestMapping("TypeTemplate/typeTemplate/add")
    public Result add(@RequestBody TbTypeTemplate typeTemplate);

    /**
     * 修改
     *
     * @param typeTemplate
     * @return
     */
    @RequestMapping("TypeTemplate/typeTemplate/update")
    public Result update(@RequestBody TbTypeTemplate typeTemplate);

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("TypeTemplate/typeTemplate/findOne")
    public TbTypeTemplate findOne(@RequestParam("id") Long id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("TypeTemplate/typeTemplate/delete")
    public Result delete(@RequestParam("ids") Long[] ids);

    /**
     * 查询+分页
     *
     * @param typeTemplate
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("TypeTemplate/typeTemplate/search")
    pageResult search(@RequestBody TbTypeTemplate typeTemplate, @RequestParam("page") int page,@RequestParam("rows") int rows);

    @RequestMapping("TypeTemplate/typeTemplate/TypeTemplateData")
    List<TypeTemplateResult> TypeTemplateData();
}


