package com.govmaz.controller.pub;


import com.govmaz.common.Result;
import com.govmaz.common.ResultCode;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.User;
import com.govmaz.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="用户管理")
@RestController
@RequestMapping("/pub/user")
public class UserController {
    @Autowired
    UserService instUserService;

    @ApiOperation("创建用户")
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