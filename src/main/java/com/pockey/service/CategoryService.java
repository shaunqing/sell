package com.pockey.service;

import com.pockey.domain.ProductCategory;
import com.pockey.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LIQing
 * 2017/10/28 16:15
 */
@Service
public class CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    public ProductCategory findOne(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
