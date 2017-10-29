package com.pockey.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by LIQing
 * 2017/10/29 21:30
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name; // 买家姓名

    @NotEmpty(message = "手机号必填")
    private String phone; // 买家手机号

    @NotEmpty(message = "地址必填")
    private String address; // 买家地址

    @NotEmpty(message = "openid必填")
    private String openId; // 买家微信openId

    @NotEmpty(message = "购物车不能为空")
    private String items; // 购物车
}
