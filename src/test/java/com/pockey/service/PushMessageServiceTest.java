package com.pockey.service;

import com.pockey.BaseTest;
import com.pockey.dto.OrderDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author LIQing
 * @create 2018-01-23 13:26
 */
public class PushMessageServiceTest extends BaseTest{

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO = orderService.findOne("");
        pushMessageService.orderStatus(orderDTO);
    }

}