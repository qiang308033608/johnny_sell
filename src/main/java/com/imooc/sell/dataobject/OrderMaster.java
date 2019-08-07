package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnums;
import com.imooc.sell.enums.PayStatusEnums;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态0新下单. */
    private Integer orderStatus= OrderStatusEnums.NEW.getCode();

    /** 支付状态0未支付. */
    private Integer payStatus= PayStatusEnums.WAIT.getCode();

    /** 创建订单时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

}
