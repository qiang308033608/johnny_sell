package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1001");
        productInfo.setProductName("矿泉水");
        productInfo.setProductPrice(new BigDecimal(2.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("有点甜");
        productInfo.setProductIcon("www.xxxx.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> productStatus = repository.findByProductStatus(0);
        Assert.assertNotEquals(1,productStatus.size());

    }
}