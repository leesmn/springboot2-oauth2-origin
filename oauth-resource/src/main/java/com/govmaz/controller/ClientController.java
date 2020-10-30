package com.govmaz.controller;

import com.govmaz.common.Result;
import com.govmaz.common.ResultCode;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.User;
import com.govmaz.entity.dto.LoginDto;
import com.govmaz.service.UserService;
import com.govmaz.utils.RestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author:
 * @date: 2018/4/17
 */



@Api(tags="登录接口")
@RestController
public class ClientController {

  @Autowired
  UserService instUserService;

  @Autowired
  RestTemplate restTemplate;

//  @ApiIgnore
//  @GetMapping("/index")
//  public Object index() {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
//    Map<String, Object> result = new HashMap<>();
//    result.put("token", details.getTokenValue());
//    result.put("type", details.getTokenType());
//    return result;
//  }


  @ApiOperation("登录")
  @PostMapping("/login")
//  @Secured("ROLE_USER")
  @ResponseBody
  public Object getToken(@RequestBody LoginDto userParam) {//@RequestBody User userParam
    User user = instUserService.selectByName(userParam.getUsername());
    if (user != null && user.getPassword().equals(userParam.getPassword())) {
      Map<String,Object> param = new HashMap<>();
      param.put("username",user.getUsername() );
      param.put("password",user.getPassword() );
//      param.put("client_secret","secret" );
//      param.put("client_id","client" );
//      param.put("scope","all" );
//      param.put("grant_type","passwaord" );
      Map<String,Object> result = (Map<String,Object>) RestUtil
          .postApi("http://127.0.0.1:8420/auth/oauth/token?password={password}&username={username}&grant_type=password&scope=all&client_id=client&client_secret=secret",param,restTemplate);
      if(!result.get("code").equals(200)){
        throw new UsernameNotFoundException("用户不存在");
      }else{
        return result;
      }
    } else {
      return ResultGenerator.genFailResult("登陆失败，账号或密码错误", ResultCode.FAIL);
    }
  }

  @ApiIgnore
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
