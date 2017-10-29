package com.pockey.dto;

import lombok.Data;

/**
 * 购物车
 * Created by LIQing
 * 2017/10/29 17:17
 */
@Data
public class CartDTO {

    private String productId; // 商品id

    private Integer productQuantity; // 数量

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
