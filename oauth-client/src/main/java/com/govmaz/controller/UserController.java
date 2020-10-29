package com.govmaz.controller;


import com.govmaz.common.Result;
import com.govmaz.common.ResultCode;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.User;
import com.govmaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService instUserService;



    @PostMapping(value = "/add")
    public Result addUser(@RequestBody User entity) throws Exception {
        User u = instUserService.selectByName(entity.getUsername());
        if(u!=null){
            ResultGenerator.genFailResult("用户名已存在", ResultCode.INTERNAL_SERVER_ERROR);
        }
        return ResultGenerator.genSuccessResult(instUserService.save(entity));
    }


//    @PostMapping(value = "/update")
//    public Result updateUser(@RequestBody User entity) throws Exception {
//        instUserService.update(entity);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping(value = "/del/{id}")
//    public Result delUserService(@PathVariable("id") int id) throws Exception {
//        instUserService.delete(id);
//        return ResultGenerator.genSuccessResult();
//    }


//    @PostMapping(value = "/login")
//    public Result login(@RequestBody User userParam) throws Exception {
//        User user = instUserService.selectByName(userParam.getUsername());
//        if (user != null && user.getPassword().equals(userParam.getPassword())) {
//            OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
//            return ResultGenerator.genSuccessResult(accessToken);
//        } else {
//            return ResultGenerator.genFailResult("登陆失败，账号或密码错误", ResultCode.FAIL);
//        }
//    }




}