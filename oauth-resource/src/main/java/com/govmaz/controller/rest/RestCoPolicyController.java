package com.govmaz.controller.rest;

import com.github.pagehelper.PageInfo;
import com.govmaz.common.Result;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.CoPolicy;
import com.govmaz.service.CoPolicyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(tags="政策管理")
@RestController
@RequestMapping("/rest/coPolicy")
public class RestCoPolicyController {
    @Autowired
    CoPolicyService instCoPolicyService;

    @ApiOperation("创建政策")
    @PostMapping(value = "/add")
    public Result addCoPolicy(@RequestBody CoPolicy entity) throws Exception {
        return ResultGenerator.genSuccessResult(instCoPolicyService.save(entity));
    }

    @ApiOperation("更新政策")
    @PostMapping(value = "/update")
    public Result updateCoPolicy(@RequestBody CoPolicy entity) throws Exception {
        instCoPolicyService.update(entity);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("指定id删除")
    @PostMapping(value = "/del/{id}")
    public Result delCoPolicyService(@PathVariable("id") int id) throws Exception {
        instCoPolicyService.delete(id);
        return ResultGenerator.genSuccessResult();
    }

//    @ApiOperation("分页获取政策列表")
//    @GetMapping(value = "/list")
//    public Result selectAllPage(@ApiParam("查看第几页") @RequestParam(value="page") int page,@ApiParam("每页多少条") @RequestParam(value="limit") int limit) throws Exception {
//        PageInfo<CoPolicy> reslut = instCoPolicyService.selectAllPage(page,limit);
//        return ResultGenerator.genSuccessPageResult(reslut);
//    }
//
//    @ApiOperation("通过id获取政策详细")
//    @GetMapping(value = "/detail/{id}")
//    public Result selectDetail(@PathVariable("id") int id) throws Exception {
//        CoPolicy reslut = instCoPolicyService.selectById(id);
//        return ResultGenerator.genSuccessResult(reslut);
//    }
}