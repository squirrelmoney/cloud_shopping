package com.jessie.mall.sellergoodsService.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbBrand;
import com.jessie.mall.pojo.TbBrandExample;
import com.jessie.mall.pojo.TbBrandExample.Criteria;
import com.jessie.mall.sellergoodsService.mapper.TbBrandMapper;
import com.jessie.mall.sellergoodsService.service.BrandService;
import org.springframework.stereotype.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Resource
	private TbBrandMapper brandMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public pageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page=   (Page<TbBrand>) brandMapper.selectByExample(null);
		return new pageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 * @return
	 */
	@Override
	public TbBrand add(TbBrand brand) {
		brandMapper.insertSelective(brand);
		return brandMapper.selectByPrimaryKey(brand.getId());

	}

	
	/**
	 * 修改
	 * @return
	 */
	@Override
	public TbBrand update(TbBrand brand){
		brandMapper.updateByPrimaryKey(brand);
		return brandMapper.selectByPrimaryKey(brand.getId());
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbBrand findOne(Long id){
		return brandMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			brandMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public pageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbBrandExample example=new TbBrandExample();
		Criteria criteria = example.createCriteria();
		
		if(brand!=null){			
						if(brand.getName()!=null && brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
			}
	
		}
		
		Page<TbBrand> page= (Page<TbBrand>)brandMapper.selectByExample(example);		
		return new pageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<TypeTemplateResult> findforType() {
		return brandMapper.findforType();
	}

}
