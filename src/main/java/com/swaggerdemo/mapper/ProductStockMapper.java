package com.swaggerdemo.mapper;

import com.swaggerdemo.pojo.ProductStock;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductStock record);

    int insertSelective(ProductStock record);

    ProductStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductStock record);

    int updateByPrimaryKey(ProductStock record);

    @Delete("delete from tb_product_stock where id =#{productId}")
    int deleteByUniqueProductId(Long productId);
    @Select("select * from tb_product_stock where product_id =#{productId} for update")
    ProductStock selectByProductId(Long productId);

    @Select("select * from tb_product_stock where product_id =#{productId}")
    ProductStock selectByProductId2(Long productId);


    @Update("Update tb_product_stock set number=#{number} where product_id = #{productId} ")
    int updateStock(Integer number, Long productId);
    @Update("Update tb_product_stock set number=#{number} set version = #{version+1 } where version = #{version}  for update")
    int updateStock2(Integer number, Long version);
}