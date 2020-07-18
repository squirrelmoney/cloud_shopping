package com.jessie.mall.sellergoodsService.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jessie.mall.common.common.TypeTemplateResult;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSpecification;
import com.jessie.mall.pojo.TbSpecificationExample;
import com.jessie.mall.pojo.TbSpecificationOption;
import com.jessie.mall.pojo.TbSpecificationOptionExample;
import com.jessie.mall.pojo.TbSpecificationOptionExample.Criteria;
import com.jessie.mall.sellergoodsService.mapper.TbSpecificationMapper;
import com.jessie.mall.sellergoodsService.mapper.TbSpecificationOptionMapper;
import com.jessie.mall.sellergoodsService.service.SpecificationService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Resource
	private TbSpecificationMapper specificationMapper;
	@Resource
	private TbSpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public pageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new pageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSpecification specification) {
		specificationMapper.insert(specification);//插入规格
		Long id=specification.getId();
		System.out.println("插入的商品属性id： "+id);
		//循环插入规格选项
		for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){
			specificationOption.setSpecId(id);//设置规格ID
			specificationOptionMapper.insert(specificationOption);
		}

	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSpecification specification){
			//保存修改的规格
			specificationMapper.updateByPrimaryKey(specification);//保存规格
			//删除原有的规格选项
			TbSpecificationOptionExample example=new TbSpecificationOptionExample();
			Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(specification.getId());//指定规格ID为条件
			specificationOptionMapper.deleteByExample(example);//删除
			//循环插入规格选项
			for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){
				specificationOption.setSpecId(specification.getId());
				specificationOptionMapper.insert(specificationOption);
			}

		}
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbSpecification findOne(Long id){
		//查询规格
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		//查询规格选项列表
		TbSpecificationOptionExample example=new TbSpecificationOptionExample();
		Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);//根据规格ID查询
		List<TbSpecificationOption> optionList = specificationOptionMapper.selectByExample(example);
		//构建组合实体类返回结果
		tbSpecification.setSpecificationOptionList(optionList);
		return tbSpecification;

	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
			//删除原有的规格选项
			TbSpecificationOptionExample example=new TbSpecificationOptionExample();
			TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);//指定规格ID为条件
			specificationOptionMapper.deleteByExample(example);//删除
		}

	}
	
	
		@Override
	public pageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		TbSpecificationExample.Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);
		return new pageResult(page.getTotal(), page.getResult());
	}
	@Override
	public List<TypeTemplateResult> findforType() {
		return specificationMapper.findforType();
	}
}
