package com.jessie.mall.sellergoodsService.controller;

import com.jessie.mall.common.common.R;
import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSpecification;
import com.jessie.mall.sellergoodsService.service.SpecificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/10 17:11
 */
@RestController
@RequestMapping("Specification/specification")
public class TbSpecificationController {
    @Resource
    private SpecificationService specificationService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll(){
        return specificationService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public pageResult  findPage(@RequestParam("page")int page,@RequestParam("rows")int rows){
        return specificationService.findPage(page, rows);
    }

    /**
     * 增加
     * @param specification
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbSpecification specification){
        try {
            specificationService.add(specification);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param specification
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbSpecification specification){
        try {
            specificationService.update(specification);
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
    public TbSpecification findOne(@RequestParam Long id){
        return specificationService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestParam Long [] ids){
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param specification
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public pageResult search(@RequestBody TbSpecification specification,@RequestParam("page") int page,@RequestParam("rows") int rows  ){
        return specificationService.findPage(specification, page, rows);
    }
    @GetMapping("/forType")
    List<TypeTemplateResult> selectforType(){
        return specificationService.findforType();
    }
}