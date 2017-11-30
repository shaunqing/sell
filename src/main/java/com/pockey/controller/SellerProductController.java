package com.pockey.controller;

import com.pockey.domain.ProductInfo;
import com.pockey.enums.ProductStatusEnum;
import com.pockey.exception.SellException;
import com.pockey.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 卖家端商品
 * Created by LIQing
 * 2017/11/30 20:53
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    /**
     * 列表
     *
     * @param page
     * @param size
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "3") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/product/list", map);
    }

    /**
     * 商品上架
     *
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/onsale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        return onOrOffSale(productId, ProductStatusEnum.UP, map);
    }

    /**
     * 商品下架
     *
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/offsale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        return onOrOffSale(productId, ProductStatusEnum.DOWN, map);
    }

    private ModelAndView onOrOffSale(String productId, ProductStatusEnum productStatusEnum, Map<String, Object> map) {
        try {
            if (productStatusEnum == ProductStatusEnum.UP) {
                productService.onSale(productId);
            } else if (productStatusEnum == ProductStatusEnum.DOWN) {
                productService.offSale(productId);
            }
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/success", map);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

    }
}
