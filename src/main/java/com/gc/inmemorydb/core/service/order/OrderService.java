package com.gc.inmemorydb.core.service.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.core.dto.system.order.OrderAddDTO;;
import com.gc.inmemorydb.core.entity.system.Order;


/**
 * @author STY
 * @version 2018/12/9/14:15
 */
public interface OrderService {

    /**
     * 创建订单
     * */
    public void createOrder(OrderAddDTO orderAddDTO);
}
