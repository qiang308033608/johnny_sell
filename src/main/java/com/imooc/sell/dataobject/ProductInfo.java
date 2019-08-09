package com.imooc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.sell.Util.EnumsUtil;
import com.imooc.sell.enums.ProductStatusEnums;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;
//  名字
    private String productName;
//  价格
    private BigDecimal productPrice;
//  库存
    private Integer productStock;
//  描述
    private String productDescription;
//  商品小图
    private String productIcon;
//  商品状态 0正常，1下架
    private Integer productStatus;
//  类目编号
    private Integer categoryType;

    /** 创建订单时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnums getProductStatusEnums(){
        return EnumsUtil.getByCode(productStatus,ProductStatusEnums.class);
    }

    public ProductInfo() {
    }
}
