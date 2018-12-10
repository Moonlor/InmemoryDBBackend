package com.gc.inmemorydb.core.service.order.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.mapper.system.FlightMapper;
import com.gc.inmemorydb.core.service.Flight.TicketService;
import com.gc.inmemorydb.core.service.global.ShiroService;
import com.gc.inmemorydb.core.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<FlightMapper, Flight> implements OrderService{

    @Autowired
    private ShiroService shiroService;

    @Override
    public Page<Flight> findCertainFlight(FindTicketDTO findTicketDTO) {
        EntityWrapper<Flight> wrapper = new EntityWrapper<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(findTicketDTO.getDeptDate());
        }
        catch(java.text.ParseException e) {
        }
        wrapper.eq("dept_date", date);
        // List<Flight> results = this.selectList(wrapper);
        Page<Flight> currentPage = this.selectPage(new Page<Flight>(findTicketDTO.getPage(), findTicketDTO.getPageSize()), wrapper);
        return currentPage;
    }
}
