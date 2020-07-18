package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.common.common.R;
import com.jessie.mall.pojo.TbBrand;
import com.jessie.mall.pojo.TbSpecification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cloud-sellergoods-service")
public interface BrandFeignClient {
    @GetMapping("Brand/brand/selectOne")
     TbBrand findOne(Long id);

    @GetMapping("Brand/brand/list")
     List<TbBrand> findAll();

    @RequestMapping("Brand/brand/findPage")
    pageResult findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @PutMapping("Brand/brand/")
     R add(@RequestBody TbBrand tbBrand);

    @PostMapping("Brand/brand/")
     R updata(@RequestBody TbBrand tbBrand);

    @GetMapping("Brand/brand/delete")
     R delete(@RequestParam  Long[] ids);

    @PostMapping("Brand/brand/search")
     R search(@RequestBody TbSpecification specification, @RequestParam("page") int page, @RequestParam("rows") int rows);

    @GetMapping("Brand/brand/forType")
    List<TypeTemplateResult> selectforType();
}

