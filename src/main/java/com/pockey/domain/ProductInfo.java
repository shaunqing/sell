package com.pockey.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pockey.enums.ProductStatusEnum;
import com.pockey.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * Created by LIQing
 * 2017/10/28 16:31
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable{

    private static final long serialVersionUID = -7274158890355924362L;

    @Id
    private String productId;

    private String productName; // 名称

    private BigDecimal productPrice; // 单价

    private Integer productStock; // 库存

    private String productDescription; //描述

    private String productIcon; // 小图

    private Integer productStatus = ProductStatusEnum.UP.getCode(); //商品状态 0正常，1下架

    private Integer categoryType; // 类目编号

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
