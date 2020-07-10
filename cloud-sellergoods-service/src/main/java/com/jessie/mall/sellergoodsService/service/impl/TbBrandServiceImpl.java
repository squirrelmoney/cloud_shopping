package com.jessie.mall.sellergoodsService.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.entity.TbBrand;
import com.jessie.mall.sellergoodsService.dao.TbBrandDao;
import com.jessie.mall.sellergoodsService.service.TbBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-07-07 14:11:55
 */
@Service("tbBrandService")
public class TbBrandServiceImpl implements TbBrandService {
    @Resource
    private TbBrandDao tbBrandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbBrand queryById(Long id) {
        return this.tbBrandDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbBrand> queryAllByLimit(int offset, int limit) {
        return this.tbBrandDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    public TbBrand insert(TbBrand tbBrand) {
        this.tbBrandDao.insert(tbBrand);
        return tbBrand;
    }

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    public TbBrand update(TbBrand tbBrand) {
        this.tbBrandDao.update(tbBrand);
        return this.queryById(tbBrand.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbBrandDao.deleteById(id) > 0;
    }

    @Override
    public pageResult findPage(Integer pageSize, Integer pageNo) {
        //分页查询控件
        PageHelper.startPage(pageNo,pageSize);
        //分页查询
        Page<TbBrand> page= (Page<TbBrand>) tbBrandDao.queryAll(null);
        return new pageResult(page.getTotal(),page.getResult());
    }

    @Override
    public pageResult blurrySearch(Integer pageSize, Integer pageNo, TbBrand brand) {
       if(pageNo<=0)
           pageNo=1;
       if (pageSize==0)
           pageSize=10;
        //分页查询控件
        PageHelper.startPage(pageNo,pageSize);
       if(brand==null||brand.getName()==null||brand.getName()==""){
           Page<TbBrand> page= (Page<TbBrand>) tbBrandDao.queryAll(null);
           return new pageResult(page.getTotal(),page.getResult());
       }
        //分页查询
        Page<TbBrand> page= (Page<TbBrand>) tbBrandDao.blurrySerach(brand);
        System.out.println(tbBrandDao.blurrySerach(brand));
        return new pageResult(page.getTotal(),page.getResult());
    }
}