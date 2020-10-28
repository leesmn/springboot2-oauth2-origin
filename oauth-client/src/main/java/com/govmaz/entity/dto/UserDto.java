package com.govmaz.entity.dto;

import lombok.Data;

@Data
public class UserDto {
  //用户名称,手机号
  private String username;

  //密码
  private String password;

  //企业id
  private Integer enterpriseId;

  private String staffName;

  private String staffJob;
}
