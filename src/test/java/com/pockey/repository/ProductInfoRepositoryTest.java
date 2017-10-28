package com.pockey.repository;

import com.pockey.BaseTest;
import com.pockey.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LIQing
 * 2017/10/28 16:36
 */
public class ProductInfoRepositoryTest extends BaseTest{

    @Autowired
    private ProductInfoRepository infoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("ddd");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("qweqwe");
        productInfo.setProductIcon("http://ssss");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo result = infoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfos = infoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }

}