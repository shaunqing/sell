package com.pockey.service;

import com.pockey.BaseTest;
import com.pockey.domain.ProductInfo;
import com.pockey.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/10/28 16:51
 */
public class ProductServiceTest extends BaseTest{
    @Test
    public void onSale() throws Exception {
        ProductInfo productInfo = productService.onSale("123");
        Assert.assertTrue("上架测试",productInfo.getProductStatusEnum() == ProductStatusEnum.UP);
    }

    @Test
    public void offSale() throws Exception {
        ProductInfo productInfo = productService.offSale("123");
        Assert.assertTrue("下架测试",productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN);
    }

    @Autowired
    private ProductService productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123");
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,5);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductName("丰富的");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("qweqwe");
        productInfo.setProductIcon("http://ssss");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productService.save(productInfo);
    }

}