package com.jessie.mall.cloudmanagerweb.Controller;

import com.jessie.mall.cloudmanagerweb.feign.SpecificationFeignClient;
import com.jessie.mall.cloudmanagerweb.feign.SpecificationOptionFeignClient;
import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSpecificationOption;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/11 16:43
 */
@RestController
@RequestMapping("SpecificationOption/specificationOption")
public class Web_SpecificationOptionController {

    @Resource
    private SpecificationOptionFeignClient specificationOptionFeignClient;
    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbSpecificationOption> findAll(){
        return specificationOptionFeignClient.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public pageResult findPage(@RequestParam("page") int page, @RequestParam("rows")int rows){
        return specificationOptionFeignClient.findPage(page,rows);
    }

    /**
     * 增加
     * @param specificationOption
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbSpecificationOption specificationOption){
        return specificationOptionFeignClient.add(specificationOption);
    }

    /**
     * 修改
     * @param specificationOption
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbSpecificationOption specificationOption){
        return  specificationOptionFeignClient.update(specificationOption);
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbSpecificationOption findOne(@RequestParam("id") Long id){
        return  specificationOptionFeignClient.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestParam("ids") Long [] ids){
        return specificationOptionFeignClient.delete(ids);
    }

    /**
     * 查询+分页
     * @param specificationOption
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public pageResult search(@RequestBody TbSpecificationOption specificationOption,@RequestParam("page") int page,@RequestParam("rows") int rows){
        return specificationOptionFeignClient.search(specificationOption,page,rows);
    }
}
