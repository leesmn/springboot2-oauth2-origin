package com.govmaz.controller;

import com.github.pagehelper.PageInfo;
import com.govmaz.common.Result;
import com.govmaz.common.ResultGenerator;
import com.govmaz.entity.CoPolicy;
import com.govmaz.service.CoPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coPolicy")
public class CoPolicyController {
    @Autowired
    CoPolicyService instCoPolicyService;

    @PostMapping(value = "/add")
    public Result addCoPolicy(@RequestBody CoPolicy entity) throws Exception {
        return ResultGenerator.genSuccessResult(instCoPolicyService.save(entity));
    }

    @PostMapping(value = "/update")
    public Result updateCoPolicy(@RequestBody CoPolicy entity) throws Exception {
        instCoPolicyService.update(entity);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "/del/{id}")
    public Result delCoPolicyService(@PathVariable("id") int id) throws Exception {
        instCoPolicyService.delete(id);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping(value = "/list")
    public Result selectAllPage(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit) throws Exception {
        PageInfo<CoPolicy> reslut = instCoPolicyService.selectAllPage(page,limit);
        return ResultGenerator.genSuccessPageResult(reslut);
    }
}