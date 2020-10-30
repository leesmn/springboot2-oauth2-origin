package com.govmaz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.govmaz.common.Result;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.ChinaAddress;
import com.govmaz.service.ChinaAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/14.
*/
@RestController
@RequestMapping("/china/address")
public class ChinaAddressController {
    @Resource
    private ChinaAddressService chinaAddressService;

    @GetMapping("/queryChinaProvice/{myColums}")
    public Result queryChinaProvice(@PathVariable String myColums){
        return ResultGenerator.genSuccessResult(chinaAddressService.queryChinaAddress(myColums,""));
    }

    @GetMapping("/queryChinaAddress/{parentId}/{myColums}")
    public Result queryChinaAddress(@PathVariable String myColums, @PathVariable String parentId){
        return ResultGenerator.genSuccessResult(chinaAddressService.queryChinaAddress(myColums,parentId));
    }

//    @GetMapping("/queryChinaAddress")
//    public Result  getAddressName(String id){
//
//    }
}
