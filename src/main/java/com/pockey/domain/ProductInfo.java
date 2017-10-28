package com.pockey.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品
 * Created by LIQing
 * 2017/10/28 16:31
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName; // 名称

    private BigDecimal productPrice; // 单价

    private Integer productStock; // 库存

    private String productDescription; //描述

    private String productIcon; // 小图

    private Integer productStatus; //商品状态 0正常，1下架

    private Integer categoryType; // 类目编号
}
