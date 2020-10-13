package com.swaggerdemo.controller;

import com.swaggerdemo.anni.CusDataSource;
import com.swaggerdemo.mapper.UserMapper;
import com.swaggerdemo.pojo.People;
import com.swaggerdemo.pojo.User;
import com.swaggerdemo.swagger.ApiError;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

@Controller
//描述类的
@Api(tags="getUser",description = "获取用户相关接口")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("user")
    @ResponseBody
    //描述方法
    @ApiOperation(tags = "getUser",value = "获取用户",produces = "application/json;charset=UTF-8"
    )
//    @ApiModelProperty
//    @ApiParam(value = "姓名",required = true,type = "query" )  或者
    @ApiImplicitParams(value = {
               @ApiImplicitParam(name = "id",value = "用户名id",required = true,paramType = "query",dataType = "long",dataTypeClass = Long.class),
               @ApiImplicitParam(name = "age",value = "年龄",required = false,paramType = "query",dataType = "string",dataTypeClass = String.class)

    })
    @ApiResponses(value = {
                @ApiResponse(code = 200,message = "相应成功",response =  People.class),
                @ApiResponse(code=400, message = "访问资源失败",response = ApiError.class)
//                @ApiResponse(code=403, message = "禁止访问",response = ApiError.class),
//                @ApiResponse(code=404, message = "请求路径错误",response = ApiError.class),

    }
    )
//    @ResponseHeader(name = "pelple",description = "aaa",response = People.class)
    public  People getUser(String id){
         People people = new  People();
        people.setAge(20);
        people.setName("钱立博");
        return people;
    }

    //@ApiImplicitParams
    @ApiIgnore
    @ApiImplicitParam(name = "address",value = "地址",required = true,paramType = "query",dataType = "string")
    public  void  test(String address){

    }


    @GetMapping("{id}")
    @ResponseBody
    @CusDataSource("dataSource1")
    public User getUser(@PathVariable("id") Long id){
        return userMapper.selectByPrimaryKey(id);
    }




}


//
//,responseHeaders = {
//@ResponseHeader(name = "content-type",description = "aaa",response = String.class),
//@ResponseHeader(name = "date",description = "date",response = Date.class)}