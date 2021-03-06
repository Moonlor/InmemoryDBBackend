package com.gc.inmemorydb.core.service.Flight.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.flight.*;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.entity.system.Report;
import com.gc.inmemorydb.core.mapper.system.FlightMapper;
import com.gc.inmemorydb.core.service.Flight.FlightStateService;
import com.gc.inmemorydb.core.service.global.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FlightStateServiceImpl extends ServiceImpl<FlightMapper, Flight> implements FlightStateService {

    @Autowired
    private ShiroService shiroService;

    @Resource
    private FlightMapper flightMapper;

    @Override
    public Page<Flight> getFlightStatus(GetFlightStateDTO getFlightStateDTO){
        EntityWrapper<Flight> wrapper = new EntityWrapper<>();
        Page<Flight> currentPage = this.selectPage(new Page<Flight>(getFlightStateDTO.getPage(), getFlightStateDTO.getPageSize()));

        return currentPage;

    }

    @Override
    public Boolean modifyFlightState(ModifyFlightDTO modifyFlightDTO){
        Flight temp = new Flight();
//        temp.setFlightId(modifyFlightDTO.getFlightId());
        temp.setStatus(modifyFlightDTO.getStatus());
        EntityWrapper<Flight> wrapper = new EntityWrapper<>();
        wrapper.eq("flight_id", modifyFlightDTO.getFlightId());
        Boolean result = this.update(temp, wrapper);
        return result;
    }

    @Override
    public Boolean modifyFlightInfo(ModifyFlightDTO modifyFlightDTO){
        Flight temp = new Flight();
//        temp.setFlightId(modifyFlightDTO.getFlightId());
        temp.setDeptDate(modifyFlightDTO.getDeptDate());
        temp.setDeptTime(modifyFlightDTO.getDeptTime());
        temp.setArriveDate(modifyFlightDTO.getArriveDate());
        temp.setArriveTime(modifyFlightDTO.getArriveTime());
        temp.setPrice(modifyFlightDTO.getPrice());
        temp.setDeptAirportCode(modifyFlightDTO.getDeptAirportCode());
        temp.setArriveAirportCode(modifyFlightDTO.getArriveAirportCode());

        EntityWrapper<Flight> wrapper = new EntityWrapper<>();
        wrapper.eq("flight_id", modifyFlightDTO.getFlightId());
        Boolean result = this.update(temp, wrapper);
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

    @Override
    public Flight searchFlightById(SearchFlightDTO searchFlightDTO){
//        Flight temp = new Flight();
//        temp.setFlightId(searchFlightDTO.getFlightId());
        EntityWrapper<Flight> wrapper = new EntityWrapper<>();
        wrapper.eq("flight_id", searchFlightDTO.getFlightId());
        Flight result =  this.selectOne(wrapper);
        return result;

    }

    @Override
    public List<Map<String, Object>> reportAirlineFlightNumber(ReportDTO reportDTO){

        return this.baseMapper.reportAirlineFlightNumber();
        
    }

    @Override
    public List<Report> reportAirlineCityNumber(ReportDTO reportDTO){
        return this.baseMapper.reportAirlineCityNumber();
    }

}
