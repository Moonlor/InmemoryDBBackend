package com.gc.inmemorydb.core.controller.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.core.dto.system.order.OrderAddDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import com.gc.inmemorydb.common.util.Tools;
import com.gc.inmemorydb.core.config.jwt.JwtToken;
import org.springframework.beans.BeanUtils;

@RestController
@RequestMapping(value = "/order")
@Api(tags = {"订单信息"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = {"/add"})
    @ApiOperation(value = "添加新订单")
    @SysLogs("添加新订单")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult add(@RequestBody @Validated @ApiParam(value = "用户数据") OrderAddDTO addDTO){


        orderService.createOrder(addDTO);
        return ResponseResult.e(ResponseCode.OK);
    }

}


