package com.jessie.mall.sellergoodsService.controller;

import com.jessie.mall.common.common.R;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.entity.TbBrand;
import com.jessie.mall.sellergoodsService.service.TbBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    private TbBrandService tbBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbBrand selectOne(Long id) {
        return this.tbBrandService.queryById(id);
    }

    @GetMapping("list")
    public List<TbBrand> selectAll() {
        return this.tbBrandService.queryAllByLimit(0, 10);
    }

    @RequestMapping("/findPage")
    public pageResult findPage(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNo") Integer pageNo) {
        return tbBrandService.findPage(pageSize, pageNo);
    }

    @PutMapping("/")
    public R save(@RequestBody TbBrand tbBrand) {
        TbBrand brand = tbBrandService.insert(tbBrand);
        return R.ok().put("data", brand);
    }

    @PostMapping("/")
    public R updata(@RequestBody TbBrand tbBrand) {
        TbBrand brand = tbBrandService.update(tbBrand);
        return R.ok().put("data", brand);
    }

    @RequestMapping("/ids")
    public R delete(@RequestBody long[] ids) {
        for (long id : ids) {
            tbBrandService.deleteById(id);
        }
        return R.ok();
    }

    @RequestMapping("/search")
    public R search(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNo") Integer pageNo,
                    @RequestBody TbBrand brand) {
        pageResult pageResult = tbBrandService.blurrySearch(pageSize, pageNo, brand);
        return R.ok().put("data", pageResult);
    }
    }
