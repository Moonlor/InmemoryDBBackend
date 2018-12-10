package com.gc.inmemorydb.core.service.Flight.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.flight.GetFlightStateDTO;
import com.gc.inmemorydb.core.dto.system.flight.InsertSingleFlightDTO;
import com.gc.inmemorydb.core.dto.system.flight.ModifyFlightDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.mapper.system.FlightMapper;
import com.gc.inmemorydb.core.service.Flight.FlightStateService;
import com.gc.inmemorydb.core.service.global.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightStateServiceImpl extends ServiceImpl<FlightMapper, Flight> implements FlightStateService {

    @Autowired
    private ShiroService shiroService;

    @Override
    public Page<Flight> getFlightStatus(GetFlightStateDTO getFlightStateDTO){
        EntityWrapper<Flight> wrapper = new EntityWrapper<>();
        Page<Flight> currentPage = this.selectPage(new Page<Flight>(getFlightStateDTO.getPage(), getFlightStateDTO.getPageSize()));

        return currentPage;

    }

    @Override
    public Boolean modifyFlightState(ModifyFlightDTO modifyFlightDTO){
        Flight temp = new Flight();
        temp.setFlightId(modifyFlightDTO.getFlightId());
        temp.setStatus(modifyFlightDTO.getStatus());
        Boolean result = this.updateById(temp);
        return result;
    }

    @Override
    public Boolean modifyFlightInfo(ModifyFlightDTO modifyFlightDTO){
        Flight temp = new Flight();
        temp.setFlightId(modifyFlightDTO.getFlightId());
        temp.setDeptDate(modifyFlightDTO.getDeptDate());
        temp.setDeptTime(modifyFlightDTO.getDeptTime());
        temp.setArriveDate(modifyFlightDTO.getArriveDate());
        temp.setArriveTime(modifyFlightDTO.getArriveTime());
        temp.setPrice(modifyFlightDTO.getPrice());
        temp.setDeptAirportCode(modifyFlightDTO.getDeptAirportCode());
        temp.setArriveAirportCode(modifyFlightDTO.getArriveAirportCode());
        Boolean result = this.updateById(temp);
        return result;
    }

    @Override
    public Boolean insertSingleFlight(InsertSingleFlightDTO insertSingleFlightDTO){
        Flight temp = new Flight();
        temp.setFlightCode(insertSingleFlightDTO.getFlightCode());
        temp.setDeptDate(insertSingleFlightDTO.getDeptDate());
        temp.setDeptTime(insertSingleFlightDTO.getDeptTime());
        temp.setArriveTime(insertSingleFlightDTO.getArriveTime());
        temp.setArriveDate(insertSingleFlightDTO.getArriveDate());
        temp.setPrice(insertSingleFlightDTO.getPrice());
        temp.setDeptAirportCode(insertSingleFlightDTO.getDeptAirportCode());
        temp.setArriveAirportCode(insertSingleFlightDTO.getArriveAirportCode());
        temp.setStatus(insertSingleFlightDTO.getState());
        temp.setAirline(insertSingleFlightDTO.getAirline());

        Boolean result = this.insert(temp);

        return result;
    }

}
