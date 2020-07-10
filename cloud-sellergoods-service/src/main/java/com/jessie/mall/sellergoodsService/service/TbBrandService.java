package com.jessie.mall.sellergoodsService.service;

import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.entity.TbBrand;
import java.util.List;
/**
 * (TbBrand)表服务接口
 *
 * @author makejava
 * @since 2020-07-07 14:11:54
 */
public interface TbBrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBrand queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbBrand> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    TbBrand insert(TbBrand tbBrand);

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    TbBrand update(TbBrand tbBrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    pageResult findPage(Integer pageSize, Integer pageNo);


    pageResult blurrySearch(Integer pageSize, Integer pageNo, TbBrand brand);
}