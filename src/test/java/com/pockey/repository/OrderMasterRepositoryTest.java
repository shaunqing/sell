package com.pockey.repository;

import com.pockey.BaseTest;
import com.pockey.domain.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/10/28 21:35
 */
public class OrderMasterRepositoryTest extends BaseTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "123123";

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234");
        orderMaster.setBuyerName("李青");
        orderMaster.setBuyerPhone("11231231232");
        orderMaster.setBuyerAddress("地址");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(12.3));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0,orderMasters.getTotalElements());
    }

}