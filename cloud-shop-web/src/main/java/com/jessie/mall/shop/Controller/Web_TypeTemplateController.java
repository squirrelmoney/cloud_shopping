package com.jessie.mall.shop.Controller;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbTypeTemplate;
import com.jessie.mall.shop.feign.TypeTemplateFeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @description:
 * @author: money
 * @time: 2020/7/12 11:28
 */
@RestController
@RequestMapping("TypeTemplate/typeTemplate")
public class Web_TypeTemplateController {
    @Resource
    private TypeTemplateFeignClient typeTemplateFeignClient;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll(){
        return typeTemplateFeignClient.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public pageResult  findPage(@RequestParam("page") int page,@RequestParam("rows") int rows){
        return typeTemplateFeignClient.findPage(page, rows);
    }

    /**
     * 增加
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateFeignClient.add(typeTemplate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateFeignClient.update(typeTemplate);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(@RequestParam("id") Long id){
        return typeTemplateFeignClient.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestParam("ids") Long [] ids){
        try {
            typeTemplateFeignClient.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param typeTemplate
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public pageResult search(@RequestBody TbTypeTemplate typeTemplate, @RequestParam("page") int page,@RequestParam("rows") int rows  ){
        return typeTemplateFeignClient.search(typeTemplate, page, rows);
    }

    /*
    *查找列表，并返回特定数据
     */
    @RequestMapping("/TypeTemplateData")
    public  List<TypeTemplateResult> TypeTemplateData(){
        return typeTemplateFeignClient.TypeTemplateData();
    }
}
