package com.swaggerdemo.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ApiError",description = "相应错误接口")
public class ApiError {


    @ApiModelProperty(value = "相应msg",name = "msg",required = true,example = "访问资源失败 ")
    private String msg;
    @ApiModelProperty(value = "相应code",name = "code",required = true,example = "400")
    private Integer code;
}
