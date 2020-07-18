package com.jessie.mall.sellergoodsService.controller;
import java.util.List;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.model.Goods;
import com.jessie.mall.pojo.TbGoods;
import com.jessie.mall.sellergoodsService.service.GoodsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/Goods/goods")
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	/**
	 * 返回全部列表
	 *
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll() {
		return goodsService.findAll();
	}


	/**
	 * 返回全部列表
	 *
	 * @return
	 */
	@RequestMapping("/findPage")
	public pageResult findPage(@RequestParam("page") int page, @RequestParam("rows") int rows) {
		return goodsService.findPage(page, rows);
	}


	/**
	 * 修改
	 *
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbGoods goods) {
		try {
			goodsService.update(goods);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}

	/**
	 * 获取实体
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbGoods findOne(@RequestParam Long id) {
		return goodsService.findOne(id);
	}

	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestParam Long[] ids) {
		try {
			goodsService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	/**
	 * 查询+分页
	 *
	 * @param goods
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public pageResult search(@RequestBody TbGoods goods, @RequestParam("page") int page, @RequestParam("rows") int rows) {
		return goodsService.findPage(goods, page, rows);
	}

	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Goods goods,@RequestParam("sellerId") String sellerId){
		//获取登录名
		System.out.println("===登陆id==="+sellerId);
		goods.getGoods().setSellerId(sellerId);//设置商家ID
		try {
			goodsService.add(goods);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

}
