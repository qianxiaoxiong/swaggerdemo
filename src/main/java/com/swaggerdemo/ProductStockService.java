package com.swaggerdemo;

import com.swaggerdemo.mapper.ProductStockMapper;
import com.swaggerdemo.pojo.ProductStock;
import com.swaggerdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockService {

    @Autowired
    private ProductStockMapper productStockMapper;

    /**
     * 悲观锁减库存：先所著表
     */
    //查询事务就会锁表(悲观锁，会锁读写）

    public Boolean  updateStock(Long productId){
        //for updata 锁表
        ProductStock productStock = productStockMapper.selectByProductId(productId);
        if(productStock.getNumber() >0){
            //已经锁住表，别人进不来 就可以操作了
             int flag =productStockMapper.updateStock(productStock.getNumber()-1,productId);
             if(flag ==  1){ //更新成功
                 return  true;
             }
             return  false;
        }
        return  false;
    }

    /**
     * 使用乐观锁
     */
    public Boolean  updateStock2(Long productId){

        //查询不加锁  for update
        ProductStock stock = productStockMapper.selectByProductId2(productId);
        //下操作加锁
        int flag = productStockMapper.updateStock2(stock.getNumber(), stock.getVersion());
        if(flag ==1){
            return true;  //减库存成功
        }
        return  false;

    }




}
