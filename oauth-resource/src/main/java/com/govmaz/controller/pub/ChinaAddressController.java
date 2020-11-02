package com.govmaz.controller.pub;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.govmaz.common.Result;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.ChinaAddress;
import com.govmaz.service.ChinaAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/14.
*/
@Api(tags="行政区域")
@RestController
@RequestMapping("/pub/china/address")
public class ChinaAddressController {
    @Resource
    private ChinaAddressService chinaAddressService;

    @ApiOperation("获取省，myColums默认值Province")
    @GetMapping("/queryChinaProvice/{myColums}")
    public Result queryChinaProvice(@PathVariable String myColums){
        return ResultGenerator.genSuccessResult(chinaAddressService.queryChinaAddress(myColums,""));
    }

    @ApiOperation("查下级行政区域")
    @GetMapping("/queryChinaAddress/{parentId}/{myColums}")
    public Result queryChinaAddress(@PathVariable String myColums, @PathVariable String parentId){
        return ResultGenerator.genSuccessResult(chinaAddressService.queryChinaAddress(myColums,parentId));
    }

//    @GetMapping("/queryChinaAddress")
//    public Result  getAddressName(String id){
//
//    }
}
