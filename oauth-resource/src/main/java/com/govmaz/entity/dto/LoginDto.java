package com.govmaz.entity.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("登录信息")
@Data
public class LoginDto {
  @ApiModelProperty("账号")
  private String username;

  //密码
  @ApiModelProperty("密码")
  private String password;
}
