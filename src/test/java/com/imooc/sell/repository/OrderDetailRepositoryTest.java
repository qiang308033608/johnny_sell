package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    private final String ORDERID="11011";
    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1011");
        orderDetail.setOrderId("ORDERID");
        orderDetail.setProductIcon("http://xxsx.jpg");
        orderDetail.setProductId("1002");
        orderDetail.setProductName("冰红茶");
        orderDetail.setProductPrice(new BigDecimal(3.0));
        orderDetail.setProductQuantity(100);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
        public void findByOrderId() {
            List<OrderDetail> orderId = orderDetailRepository.findByOrderId(ORDERID);
            Assert.assertNotEquals(0,orderId.size());
            System.out.println(orderId);
    }
}