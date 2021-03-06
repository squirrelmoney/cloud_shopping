package com.jessie.mall.shop.Controller;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSeller;
import com.jessie.mall.shop.feign.SellerFeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 17:06
 */
@RestController
@RequestMapping("/Seller/seller")
public class Web_SellerController {

        @Resource
        private SellerFeignClient sellerFeignClient;

        /**
         * 返回全部列表
         * @return
         */
        @RequestMapping("/findAll")
        public List<TbSeller> findAll(){
            return sellerFeignClient.findAll();
        }


        /**
         * 返回全部列表
         * @return
         */
        @RequestMapping("/findPage")
        public pageResult findPage(@RequestParam("page") int page, @RequestParam("rows") int rows){
            return sellerFeignClient.findPage(page, rows);
        }

        /**
         * 增加
         * @param seller
         * @return
         */
        @RequestMapping("/add")
        public Result add(@RequestBody TbSeller seller){
            try {
                sellerFeignClient.add(seller);
                return new Result(true, "增加成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "增加失败");
            }
        }

        /**
         * 修改
         * @param seller
         * @return
         */
        @RequestMapping("/update")
        public Result update(@RequestBody TbSeller seller){
            try {
                sellerFeignClient.update(seller);
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
        public TbSeller findOne(@RequestParam String id){
            return sellerFeignClient.findOne(id);
        }

        /**
         * 批量删除
         * @param ids
         * @return
         */
        @RequestMapping("/delete")
        public Result delete(@RequestParam String [] ids){
            try {
                sellerFeignClient.delete(ids);
                return new Result(true, "删除成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "删除失败");
            }
        }

        /**
         * 查询+分页
         * @param seller
         * @param page
         * @param rows
         * @return
         */
        @RequestMapping("/search")
        public pageResult search(@RequestBody TbSeller seller, @RequestParam("page") int page, @RequestParam("rows") int rows  ){
            return sellerFeignClient.search(seller, page, rows);
        }

    /**
     * 更改状态
     * @param sellerId 商家ID
     * @param status 状态
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(@RequestParam("sellerId") String sellerId,@RequestParam("status") String status){
            return sellerFeignClient.updateStatus(sellerId,status);
    }
}
