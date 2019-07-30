package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory categoryServiceOne = categoryService.findOne(3);
        Assert.assertEquals(new Integer(3),categoryServiceOne.getCategoryId());

    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryServiceAll = categoryService.findAll();
        Assert.assertNotEquals(0,categoryServiceAll.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory("女生专用",1);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}