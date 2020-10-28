package com.govmaz.controller;

import com.govmaz.common.Result;
import com.govmaz.common.ResultCode;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.User;
import com.govmaz.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:
 * @date: 2018/4/17
 */
@RestController
public class ClientController {


  @Autowired
  UserService instUserService;

  @Autowired
  OAuth2RestTemplate oAuth2RestTemplate;

  @GetMapping("/index")
  public Object index() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
    Map<String, Object> result = new HashMap<>();
    result.put("token", details.getTokenValue());
    result.put("type", details.getTokenType());
    return result;
  }

  @PostMapping("/token")
//  @Secured("ROLE_USER")
  @ResponseBody
  public Object getToken(@RequestBody User userParam) {//@RequestBody User userParam
    User user = instUserService.selectByName(userParam.getUsername());
    if (user != null && user.getPassword().equals(userParam.getPassword())) {
      OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
      return ResultGenerator.genSuccessResult(accessToken);
    } else {
      return ResultGenerator.genFailResult("登陆失败，账号或密码错误", ResultCode.FAIL);
    }
  }

  @GetMapping(value = "/userinfo")
  @ResponseBody
  public Result selectByName(@RequestParam(value = "username") String username) throws Exception {
    User user = instUserService.selectByName(username);
    if (user != null) {
      return ResultGenerator.genSuccessResult(user.getPassword());
    }
    return ResultGenerator.genFailResult("用户不存在", ResultCode.INTERNAL_SERVER_ERROR);
  }
}
