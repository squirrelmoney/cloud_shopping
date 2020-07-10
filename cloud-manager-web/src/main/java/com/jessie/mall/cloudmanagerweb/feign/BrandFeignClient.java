package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.R;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.entity.TbBrand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("cloud-sellergoods-service")
public interface BrandFeignClient {
    @GetMapping("/Brand/brand/findPage")
     pageResult findPage(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageNo") Integer pageNo);

    @PutMapping("/Brand/brand/")
    R save(@RequestBody TbBrand tbBrand);

    @PostMapping("/Brand/brand/")
    R updata(@RequestBody TbBrand tbBrand);

    @RequestMapping("/Brand/brand/ids")
    R delete(@RequestBody long[] ids);

    @RequestMapping("/Brand/brand/search")
    R search(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNo") Integer pageNo,
             @RequestBody TbBrand brand);
}
