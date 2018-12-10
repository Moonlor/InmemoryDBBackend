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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import com.gc.inmemorydb.common.util.Tools;
import com.gc.inmemorydb.core.config.jwt.JwtToken;
import org.springframework.beans.BeanUtils;


@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Ticketorder> implements OrderService{

    @Autowired
    private ShiroService shiroService;

    @Override
    public void createOrder(OrderAddDTO orderAddDTO) {


        Tools.executeLogin();
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            System.out.print("劉嘉澍牛逼！");
        }
        JwtToken jwtToken = new JwtToken();
        Object principal = subject.getPrincipal();
        if(principal==null){
            System.out.print("劉嘉澍牛逼！");
        }
        BeanUtils.copyProperties(principal,jwtToken);


        Ticketorder temp = new Ticketorder();
        temp.setUserId(Integer.parseInt(jwtToken.getUid()));
        temp.setFlightId(orderAddDTO.getFlightId());



        this.insert(temp);

    }
}