package com.gc.inmemorydb.common.controller;

import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.common.service.QueryService;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Licoy
 * @version 2018/5/25/13:27
 */
public interface QueryController<E,FD,S extends QueryService<E,FD>> {

    S getService();

    @PostMapping("/list")
    @ApiOperation(value = "分页获取所有列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token",required = true)
    default ResponseResult<Page<E>> list(@RequestBody FD findDTO){
        return ResponseResult.e(ResponseCode.OK,getService().list(findDTO));
    }

}
