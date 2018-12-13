package com.gc.inmemorydb.core.service.order;


import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.core.dto.system.order.OrderAddDTO;
import com.gc.inmemorydb.core.dto.system.order.GetOrderDTO;
import com.gc.inmemorydb.core.entity.system.Ticketorder;
import com.gc.inmemorydb.core.entity.system.OrderInfo;
import com.gc.inmemorydb.core.config.jwt.JwtToken;


/**
 * @author STY
 * @version 2018/12/9/14:15
 */
public interface OrderService {

    /**
     * 创建订单
     * */
    public void createOrder(OrderAddDTO orderAddDTO);


    /**
     * 查询当前订单列表
     * */
    public Page<OrderInfo> getOrderInfo(GetOrderDTO getOrderDTO);


    /**
     * 获取JWTToken
     * */
    public JwtToken getJWTToken();

    /**
     * 删除订单
     * @param orderId
     */
    void remove(String orderId);
}
