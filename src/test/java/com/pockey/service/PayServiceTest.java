package com.pockey.service;

import com.pockey.BaseTest;
import com.pockey.dto.OrderDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/11/26 17:24
 */
public class PayServiceTest extends BaseTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1509270270713899319");
        payService.create(orderDTO);
    }

}