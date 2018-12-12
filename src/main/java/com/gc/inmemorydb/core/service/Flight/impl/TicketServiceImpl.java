package com.gc.inmemorydb.core.service.Flight.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.mapper.system.FlightMapper;
import com.gc.inmemorydb.core.service.Flight.TicketService;
import com.gc.inmemorydb.core.service.global.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TicketServiceImpl extends ServiceImpl<FlightMapper, Flight> implements TicketService {

    @Autowired
    private ShiroService shiroService;

    @Resource
    private FlightMapper flightMapper;

    @Override
    @DS("tt")
    public Page<Flight> findCertainFlight(FindTicketDTO findTicketDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(findTicketDTO.getDeptDate());
        }
        catch(java.text.ParseException e) {
        }
        findTicketDTO.setDeptDate(sdf.toString());
        String costTime = UUID.randomUUID().toString();
        Page<Flight> page = new Page<>(findTicketDTO.getPage(), findTicketDTO.getPageSize());
        List<Flight> o = this.baseMapper.findCertainFlightSQL(page,
                sdf.format(date),
                findTicketDTO.getDeptCity(),
                findTicketDTO.getArriveCity());
        return page.setRecords(o);
    }
}
