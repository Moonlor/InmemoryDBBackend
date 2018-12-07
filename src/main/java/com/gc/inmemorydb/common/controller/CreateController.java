package com.gc.inmemorydb.common.controller;

import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.service.CreateService;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Licoy
 * @version 2018/5/25/12:54
 */
public interface CreateController<AD,S extends CreateService<AD>> {

    S getService();

    @PostMapping("/add")
    @ApiOperation(value = "添加新增")
    @SysLogs("添加新增")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token",required = true)
    default ResponseResult add(@RequestBody @Validated AD a){
        getService().add(a);
        return ResponseResult.e(ResponseCode.OK);
    }
}
