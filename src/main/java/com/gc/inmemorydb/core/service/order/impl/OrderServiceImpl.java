package com.gc.inmemorydb.core.service.order.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.order.OrderAddDTO;
import com.gc.inmemorydb.core.entity.system.Ticketorder;

import com.gc.inmemorydb.core.mapper.system.OrderMapper;
import com.gc.inmemorydb.core.service.global.ShiroService;
import com.gc.inmemorydb.core.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Ticketorder> implements OrderService{

    @Autowired
    private ShiroService shiroService;

    @Override
    public void createOrder(OrderAddDTO orderAddDTO) {

<<<<<<< HEAD
        //Flight flight = this.selectOne(new EntityWrapper<Flight>().eq("flightId",orderAddDTO.getFlightId()));
=======
        Ticketorder temp = new Ticketorder();
        temp.setUserId(2);
        temp.setFlightId(orderAddDTO.getFlightId());



        this.insert(temp);
>>>>>>> 74d63e2a28013ce7fcfffc4ecdb5acb73dcf72eb

    }
}