package com.jessie.mall.sellergoodsService.service;
import java.util.List;

import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.pojo.TbBrand;
import com.jessie.mall.common.common.pageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbBrand> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public pageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
     * @return
     */
	public TbBrand add(TbBrand brand);
	
	
	/**
	 * 修改
     * @return
     */
	public TbBrand update(TbBrand brand);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public pageResult findPage(TbBrand brand, int pageNum, int pageSize);

    List<TypeTemplateResult> findforType();
}
