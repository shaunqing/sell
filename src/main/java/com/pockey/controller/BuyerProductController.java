package com.pockey.controller;

import com.pockey.VO.ProductInfoVO;
import com.pockey.VO.ProductVO;
import com.pockey.VO.ResultVO;
import com.pockey.domain.ProductCategory;
import com.pockey.domain.ProductInfo;
import com.pockey.service.CategoryService;
import com.pockey.service.ProductService;
import com.pockey.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by LIQing
 * 2017/10/28 17:02
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product", key = "123")
    public ResultVO list(String sellerId) {
        // 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 查询类目（一次性查询）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 两个类之间拷贝数据
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
