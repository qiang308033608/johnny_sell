package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnums;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findone() {
        ProductInfo result = productInfoService.findone("1001");
        Assert.assertNotNull(result);

    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productInfoService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<ProductInfo> result = productInfoService.findAll(pageRequest);
        System.out.println(result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1002");
        productInfo.setProductName("冰红茶");
        productInfo.setProductPrice(new BigDecimal(3.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好喝");
        productInfo.setProductIcon("www.xxxx.com");
        productInfo.setProductStatus(ProductStatusEnums.DOWN.getCode());
        productInfo.setCategoryType(4);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}