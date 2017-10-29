package com.pockey.dto;

import com.pockey.domain.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by LIQing
 * 2017/10/29 16:42
 */
@Data
public class OrderDTO {

    private String orderId; //订单id

    private String buyerName; // 买家姓名

    private String buyerPhone; // 买家手机

    private String buyerAddress; // 买家地址

    private String buyerOpenid; // 买家微信Openid

    private BigDecimal orderAmount; // 订单总金额

    private Integer orderStatus; // 订单状态，默认为新下单

    private Integer payStatus; // 支付状态，默认为0未支付

    private Date createTime; // 创建时间

    private Date updateTime; // 更新时间

    private List<OrderDetail> orderDetailList;
}
