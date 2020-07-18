package com.jessie.mall.cloudmanagerweb.Controller;
import com.jessie.mall.cloudmanagerweb.feign.SpecificationFeignClient;
import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSpecification;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/10 17:03
 */
@RestController
@RequestMapping("/Specification/specification")
public class Web_SpecificationController {
    @Resource
    private SpecificationFeignClient specificationFeignClient;

    @GetMapping("/list")
    public List<TbSpecification> select(){
        return specificationFeignClient.findAll();
    }

    @GetMapping("/forType")
    public List<TypeTemplateResult> selectforType(){
        return specificationFeignClient.selectforType();
    }

    @RequestMapping("/findPage")
    public pageResult findPage(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNo") Integer pageNo){
        return specificationFeignClient.findPage(pageSize,pageNo);
    }
    @GetMapping("/findOne")
    public TbSpecification findOne(@RequestParam Long id){
        return specificationFeignClient.findOne(id);
    }

    @PutMapping("/")
    public Result save(@RequestBody TbSpecification tbSpecification){
        return specificationFeignClient.add(tbSpecification);
    }

    @PostMapping("/")
    public Result updata(@RequestBody TbSpecification tbSpecification){
        return specificationFeignClient.update(tbSpecification);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Long[] ids){
        return specificationFeignClient.delete(ids);
    }

    @PostMapping("/search")
    public pageResult search(@RequestBody TbSpecification specification, @RequestParam("page") int page, @RequestParam("rows") int rows  ){
        return specificationFeignClient.search(specification,page,rows);
    }
}
