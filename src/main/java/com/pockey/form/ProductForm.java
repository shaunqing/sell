package com.pockey.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by LIQing
 * 2017/12/2 10:44
 */
@Data
public class ProductForm {

    private String productId;

    private String productName; // 名称

    private BigDecimal productPrice; // 单价

    private Integer productStock; // 库存

    private String productDescription; //描述

    private String productIcon; // 小图

    private Integer categoryType; // 类目编号

}
