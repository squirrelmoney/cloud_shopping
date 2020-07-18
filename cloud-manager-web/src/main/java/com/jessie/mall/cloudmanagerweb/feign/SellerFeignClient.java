package com.jessie.mall.cloudmanagerweb.feign;

import com.jessie.mall.common.common.Result;
import com.jessie.mall.common.common.pageResult;
import com.jessie.mall.pojo.TbSeller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("cloud-sellergoods-service")
public interface SellerFeignClient {

        /**
         * 返回全部列表
         * @return
         */
        @RequestMapping("/Seller/seller/findAll")
        public List<TbSeller> findAll();


        /**
         * 返回全部列表
         * @return
         */
        @RequestMapping("/Seller/seller/findPage")
        public pageResult findPage(@RequestParam("page") int page, @RequestParam("rows") int rows);
        /**
         * 增加
         * @param seller
         * @return
         */
        @RequestMapping("/Seller/seller/add")
        public Result add(@RequestBody TbSeller seller);

        /**
         * 修改
         * @param seller
         * @return
         */
        @RequestMapping("/Seller/seller/update")
        public Result update(@RequestBody TbSeller seller);

        /**
         * 获取实体
         * @param id
         * @return
         */
        @RequestMapping("/Seller/seller/findOne")
        public TbSeller findOne(@RequestParam String id);

        /**
         * 批量删除
         * @param ids
         * @return
         */
        @RequestMapping("/Seller/seller/delete")
        public Result delete(@RequestParam String [] ids);

        /**
         * 查询+分页
         * @param seller
         * @param page
         * @param rows
         * @return
         */
        @RequestMapping("/Seller/seller/search")
        public pageResult search(@RequestBody TbSeller seller, @RequestParam("page") int page, @RequestParam("rows") int rows );

        @RequestMapping("/Seller/seller/updateStatus")
        Result updateStatus(@RequestParam("sellerId") String sellerId,@RequestParam("status") String status);
}
