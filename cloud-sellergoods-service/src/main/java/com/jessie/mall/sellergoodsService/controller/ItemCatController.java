package com.jessie.mall.sellergoodsService.controller;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbItemCat;
import com.jessie.mall.sellergoodsService.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/ItemCat/itemCat")
public class ItemCatController {

	@Resource
	private ItemCatService itemCatService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbItemCat> findAll(){
		return itemCatService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public pageResult  findPage(int page,int rows){
		return itemCatService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbItemCat itemCat){
		try {
			itemCatService.add(itemCat);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbItemCat itemCat){
		try {
			itemCatService.update(itemCat);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbItemCat findOne(Long id){
		return itemCatService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			itemCatService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param itemCat
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public pageResult search(@RequestBody TbItemCat itemCat, int page, int rows  ){
		return itemCatService.findPage(itemCat, page, rows);		
	}

	/**
	 * 根据上级ID查询列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findByParentId")
	public   pageResult findByParentId(@RequestParam("parentId") Long parentId,@RequestParam("page") int page, @RequestParam("rows") int rows){
		return itemCatService.findByParentId(parentId, page, rows);
	}
	/**
	 * 根据上级ID查询列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findOnlyByParentId")
	public  List<TbItemCat> findOnlyByParentId(@RequestParam("parentId") Long parentId){
		return itemCatService.findByParentId(parentId);
	}
}
