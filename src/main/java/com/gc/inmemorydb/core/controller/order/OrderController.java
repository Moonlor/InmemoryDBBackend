package com.gc.inmemorydb.core.controller.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.core.dto.system.order.GetOrderDTO;
import com.gc.inmemorydb.core.dto.system.order.OrderAddDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.entity.system.OrderInfo;
import com.gc.inmemorydb.core.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = {"/list"})
    @ApiOperation(value = "获取所有的订单列表")
    @SysLogs("获取所有的订单列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult list(@RequestBody GetOrderDTO getOrderDTO){
        Page<OrderInfo> results = orderService.getOrderInfo(getOrderDTO);
        return ResponseResult.e(ResponseCode.OK,results);
    }

    @PostMapping(value = {"/remove/{orderId}"})
    @ApiOperation(value = "删除订单")
    @SysLogs("删除订单")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult remove(@PathVariable("orderId") @ApiParam("订单ID") String orderId){
        System.out.println(orderId);
        orderService.remove(orderId);
        return ResponseResult.e(ResponseCode.OK);
    }



}


