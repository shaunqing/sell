package com.pockey.controller;

import com.pockey.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LIQing
 * @create 2018-01-26 12:37
 */
@RestController
@RequestMapping("/skill")
@Slf4j
public class SeckillController {

    @Autowired
    private SeckillService seckillService;


    /**
     * 查询秒杀活动特价商品信息
     *
     * @param productId
     * @return
     * @throws Exception
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId) throws Exception {
        return seckillService.querySeckillProductInfo(productId);
    }


    /**
     * 秒杀，没有抢到获得“哎呦喂，xxx”，抢到了会返回剩余的库存量
     *
     * @param productId
     * @return
     * @throws Exception
     */
    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId) throws Exception {
        log.info("@skill request, productId:" + productId);
        seckillService.orderProductMockDiffUser(productId);
        return seckillService.querySeckillProductInfo(productId);
    }

}
