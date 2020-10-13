package com.swaggerdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "person", description = "person实体类")
public  class People {
    @ApiModelProperty(value = "用户id", name = "id", required = true, example = "2 ")
    private Long id;
    @ApiModelProperty(value = "姓名", name = "name", required = true, example = "钱立博 ")
    private String name;
    @ApiModelProperty(value = "年龄", name = "age", required = true, example = "18 ")
    private Integer age;
}
