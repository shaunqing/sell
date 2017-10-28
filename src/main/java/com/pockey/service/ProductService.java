package com.pockey.service;

import com.pockey.domain.ProductInfo;
import com.pockey.enums.ProductStatusEnum;
import com.pockey.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LIQing
 * 2017/10/28 16:43
 */
@Service
public class ProductService {

    @Autowired
    private ProductInfoRepository repository;

    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    /**
     * 查询所有上架商品
     *
     * @return
     */
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    // TODO 加库存

    // TODO 减库存
}
