package com.jessie.mall.cloudmanagerweb.Controller;
import com.jessie.mall.cloudmanagerweb.feign.BrandFeignClient;
import com.jessie.mall.common.common.R;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.entity.TbBrand;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
//    @Resource
//    private RestTemplate restTemplate;
    @Resource
    private BrandFeignClient brandFeignClient;

    //String REST_URL_PREFIX="http://cloud-sellergoods-service";
//    @GetMapping("/list")
//    public List<TbBrand> select(){
//        return restTemplate.getForObject(REST_URL_PREFIX + "/Brand/brand/list",List.class);
//    }
    @RequestMapping("/findPage")
    public pageResult findPage(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNo") Integer pageNo){
        return brandFeignClient.findPage(pageSize,pageNo);
    }

    @PutMapping("/")
    public R save(@RequestBody TbBrand tbBrand){
       return brandFeignClient.save(tbBrand);
    }

    @PostMapping("/")
    public R updata(@RequestBody TbBrand tbBrand){
        return brandFeignClient.updata(tbBrand);
    }

    @RequestMapping("/ids")
    public R delete(@RequestBody long[] ids){
        return brandFeignClient.delete(ids);
    }

    @RequestMapping("/search")
    public R search(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNo") Integer pageNo,
                    @RequestBody TbBrand brand){
        return brandFeignClient.search(pageSize,pageNo,brand);
    }
}
