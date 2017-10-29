package com.pockey.service;

import com.pockey.domain.ProductInfo;
import com.pockey.dto.CartDTO;
import com.pockey.enums.ProductStatusEnum;
import com.pockey.enums.ResultEnum;
import com.pockey.exception.SellException;
import com.pockey.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 加库存
     *
     * @param cartDTOList
     */
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    /**
     * 减库存
     *
     * @param cartDTOList
     */
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }
}
