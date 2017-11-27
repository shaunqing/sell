package com.pockey.service;

import com.pockey.BaseTest;
import com.pockey.domain.OrderDetail;
import com.pockey.dto.OrderDTO;
import com.pockey.enums.OrderStatusEnum;
import com.pockey.enums.PayStatusEnum;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/10/29 17:30
 */
@Slf4j
public class OrderServiceTest extends BaseTest {

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1509270411829286399";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerName("搜索");
        orderDTO.setBuyerPhone("11111");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1234");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        o1 = new OrderDetail();
        o1.setProductId("123");
        o1.setProductQuantity(3);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}", orderDTO);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
//        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
        // 这样写可以保持格式统一
        Assert.assertTrue("查询所有的订单列表", orderDTOPage.getTotalElements() > 0);
    }

}