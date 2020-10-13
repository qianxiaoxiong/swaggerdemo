package com.swaggerdemo.controller;

import com.swaggerdemo.anni.CusDataSource;
import com.swaggerdemo.mapper.ProductStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductStockController {
    /**
     * 减库存
     *
     * 使用乐观锁
     */
    @Autowired
    private ProductStockMapper productStockMapper;

    @GetMapping("{productId}")
    @CusDataSource("dataSource2")
    public Boolean decrease(@PathVariable("productId") Long productId){
        int i = productStockMapper.deleteByUniqueProductId(productId);
        return  i ==1 ? true: false;
    }
}
