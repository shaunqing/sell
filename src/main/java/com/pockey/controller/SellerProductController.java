package com.pockey.controller;

import com.pockey.domain.ProductCategory;
import com.pockey.domain.ProductInfo;
import com.pockey.enums.ProductStatusEnum;
import com.pockey.exception.SellException;
import com.pockey.form.ProductForm;
import com.pockey.service.CategoryService;
import com.pockey.service.ProductService;
import com.pockey.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        // 查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index", map);
    }

    /**
     * 保存 / 更新
     *
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
//    @CachePut(cacheNames = "product", key = "123")
//    @CacheEvict(cacheNames = "product", key = "123")
    public ModelAndView save(@Valid ProductForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        try {
            ProductInfo productInfo = new ProductInfo();
            // 如果productId不为空，说明是修改，否则是新增
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            } else {
                form.setProductId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form, productInfo);

            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


}
