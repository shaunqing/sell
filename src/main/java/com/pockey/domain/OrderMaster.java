package com.pockey.domain;

import com.pockey.enums.OrderStatusEnum;
import com.pockey.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by LIQing
 * 2017/10/28 21:19
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId; //订单id

    private String buyerName; // 买家姓名

    private String buyerPhone; // 买家手机

    private String buyerAddress; // 买家地址

    private String buyerOpenid; // 买家微信Openid

    private BigDecimal orderAmount; // 订单总金额

    private Integer orderStatus = OrderStatusEnum.NEW.getCode(); // 订单状态，默认为新下单

    private Integer payStatus = PayStatusEnum.WAIT.getCode(); // 支付状态，默认为0未支付

    private Date createTime; // 创建时间

    private Date updateTime; // 更新时间

}
