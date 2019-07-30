package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/*
* 类目
* */
public interface CategoryService {
    /*
    * 查询一个、查询所有是供后台使用的
    * */
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    /*查询类目，买家端*/
    List<ProductCategory> findByCategoryTypeIn (List<Integer> categoryTypeList);

    /*更新 保存*/
    ProductCategory save(ProductCategory productCategory);



}
