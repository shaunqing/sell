package com.pockey.domain.mapper;

import com.pockey.BaseTest;
import com.pockey.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author LIQing
 * @create 2018-01-25 13:38
 */
public class ProductCategoryMapperTest extends BaseTest{

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name","测试123");
        map.put("category_type",102);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试342");
        productCategory.setCategoryType(109);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = mapper.findByCategoryType(102);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> productCategory = mapper.findByCategoryName("测试342");
        Assert.assertNotEquals(0,productCategory.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("测试bug",102);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试342333333");
        productCategory.setCategoryType(109);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteCategoryType() {
        int result = mapper.deleteByCategoryType(109);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(102);
        Assert.assertNotNull(productCategory);
    }

}