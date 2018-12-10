package com.gc.inmemorydb.core.service.order.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.order.OrderAddDTO;
import com.gc.inmemorydb.core.entity.system.Order;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.mapper.system.OrderMapper;
import com.gc.inmemorydb.core.service.global.ShiroService;
import com.gc.inmemorydb.core.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{

    @Autowired
    private ShiroService shiroService;

    @Override
    public void createOrder(OrderAddDTO orderAddDTO) {

        Flight flight = this.selectOne(new EntityWrapper<Flight>().eq("flightId",orderAddDTO.getFlightId()));

    }
}