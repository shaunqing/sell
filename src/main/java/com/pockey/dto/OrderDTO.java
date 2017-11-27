package com.pockey.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pockey.domain.OrderDetail;
import com.pockey.enums.OrderStatusEnum;
import com.pockey.enums.PayStatusEnum;
import com.pockey.utils.EnumUtil;
import com.pockey.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by LIQing
 * 2017/10/29 16:42
 */
@Data
// 不返回结果为null的属性：@JsonInclude(JsonInclude.Include.NON_NULL)，也可在配置文件中配置
public class OrderDTO {

    private String orderId; //订单id

    private String buyerName; // 买家姓名

    private String buyerPhone; // 买家手机

    private String buyerAddress; // 买家地址

    private String buyerOpenid; // 买家微信Openid

    private BigDecimal orderAmount; // 订单总金额

    private Integer orderStatus; // 订单状态，默认为新下单

    private Integer payStatus; // 支付状态，默认为0未支付

    // 将时间格式改为秒级别的时间戳
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime; // 创建时间

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime; // 更新时间

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
