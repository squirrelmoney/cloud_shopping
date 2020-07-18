package com.jessie.mall.sellergoodsService.controller;

import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.common.common.R;
import com.jessie.mall.pojo.TbBrand;
import com.jessie.mall.sellergoodsService.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbBrand)表控制层
 *
 * @author makejava
 * @since 2020-07-07 14:11:55
 */
@RestController
@RequestMapping("Brand/brand")
public class TbBrandController {
    /**
     * 服务对象
     */
    @Resource
    private BrandService tbBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbBrand findOne(Long id) {
        return this.tbBrandService.findOne(id);
    }

    @GetMapping("list")
    public List<TbBrand> findAll() {
        return this.tbBrandService.findAll();
    }

    @RequestMapping("/findPage")
    public pageResult findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        return tbBrandService.findPage(page, rows);
    }

    @PutMapping("/")
    public R add(@RequestBody TbBrand tbBrand) {
        TbBrand add = tbBrandService.add(tbBrand);
        return R.ok().put("data",add);
    }

    @PostMapping("/")
    public R updata(@RequestBody TbBrand tbBrand) {
        TbBrand update = tbBrandService.update(tbBrand);
        return R.ok().put("data",update);
    }

    @GetMapping("/delete")
    public R delete(@RequestParam Long[] ids) {
            tbBrandService.delete(ids);
            return R.ok();
    }

    @RequestMapping("/search")
    public R search(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,
                    @RequestBody TbBrand brand) {
        pageResult pageResult = tbBrandService.findPage(brand,page,rows);
        return R.ok().put("data", pageResult);
    }

    @GetMapping("/forType")
    List<TypeTemplateResult> selectforType(){
     return tbBrandService.findforType();
    }
    }
