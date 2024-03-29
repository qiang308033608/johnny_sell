package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnums;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {

        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO==null){
            log.error("【取消订单】 查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnums.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null){
            return null;
        }
        //判断订单是否属于自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询叮当】 订单的openid不一致.openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnums.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
