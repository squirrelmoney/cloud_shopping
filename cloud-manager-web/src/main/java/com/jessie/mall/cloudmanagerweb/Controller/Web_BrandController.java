package com.jessie.mall.cloudmanagerweb.Controller;
import com.jessie.mall.cloudmanagerweb.feign.BrandFeignClient;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.common.common.R;
import com.jessie.mall.pojo.TbBrand;
import com.jessie.mall.pojo.TbSpecification;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/7 15:27
 */
@RestController
@RequestMapping("/Brand/brand")
public class Web_BrandController {
    @Resource
    private BrandFeignClient brandFeignClient;

    @GetMapping("/list")
    public List<TbBrand> select(){
        return brandFeignClient.findAll();
    }

    @GetMapping("/forType")
    public  List<TypeTemplateResult> selectforType(){
        return brandFeignClient.selectforType();
    }

    @RequestMapping("/findPage")
    public pageResult findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        return brandFeignClient.findPage(page,rows);
    }

    @PutMapping("/")
    public R save(@RequestBody TbBrand tbBrand){
       return brandFeignClient.add(tbBrand);
    }

    @PostMapping("/")
    public R updata(@RequestBody TbBrand tbBrand){
        return brandFeignClient.updata(tbBrand);
    }

    @GetMapping("/delete")
    public R delete(@RequestParam Long[] ids){
        return brandFeignClient.delete(ids);
    }

    @PostMapping("/search")
    public R search(@RequestBody TbSpecification specification, @RequestParam("page") int page, @RequestParam("rows") int rows){
        return brandFeignClient.search(specification,page,rows);
    }
}
