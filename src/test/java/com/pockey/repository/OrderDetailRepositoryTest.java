package com.pockey.repository;

import com.pockey.BaseTest;
import com.pockey.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/10/28 21:45
 */
public class OrderDetailRepositoryTest extends BaseTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1231888");
        orderDetail.setOrderId("11111");
        orderDetail.setProductIcon("http://ssss.ico");
        orderDetail.setProductId("1231235");
        orderDetail.setProductName("对对对");
        orderDetail.setProductPrice(new BigDecimal(4.6));
        orderDetail.setProductQuantity(33);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}