package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    /**订单id. */
    @Id
    private String detailId;

    /**订单id. */
    private String orderId;

    /** 产品Id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品价格. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;

    public OrderDetail() {
    }
}
