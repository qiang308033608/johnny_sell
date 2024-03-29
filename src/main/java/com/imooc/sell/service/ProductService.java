package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
* 商品
* */
public interface ProductService {

    ProductInfo findone(String productId);

//  查询在架商品
    List<ProductInfo> findUpAll();

//  卖家端？ 查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

//  加库存
    void increaseStock(List<CartDTO> cartDTOList);

//  减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
