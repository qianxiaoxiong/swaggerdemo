package com.swaggerdemo.mapper;

import com.swaggerdemo.anni.CusDataSource;
import com.swaggerdemo.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    @Select("select * from tb_user where id =#{id}")
    User selectByPrimaryKey(Long id);

//    int deleteByPrimaryKey(Long id);
//
//    int insert( User record);
//
//    int insertSelective( User record);
//
//
//    int updateByPrimaryKeySelective( User record);
//
//    int updateByPrimaryKey( User record);
}