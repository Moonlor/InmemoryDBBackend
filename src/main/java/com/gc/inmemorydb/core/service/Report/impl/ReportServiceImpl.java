package com.gc.inmemorydb.core.service.Report.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.report.*;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.mapper.system.FlightMapper;
import com.gc.inmemorydb.core.mapper.system.ReportMapper;
import com.gc.inmemorydb.core.service.Flight.TicketService;
import com.gc.inmemorydb.core.service.Report.ReportService;
import com.gc.inmemorydb.core.service.global.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Flight> implements ReportService {

    @Autowired
    private ShiroService shiroService;

    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<CertainAirlineReportDTO> certainAirlineReport(GetCertainAirlineReportDTO getCertainAirlineReportDTO, String sqlUid) {
        this.baseMapper.generateCertainAirlineReport(getCertainAirlineReportDTO.getYear(),
                getCertainAirlineReportDTO.getAirline(),
                sqlUid);

        return this.baseMapper.getCertainAirlineReport();
    }

    @Override
    public List<AirlineYearReportDTO> airlineYearReport(GetAirlineYearReportDTO getAirlineYearReportDTO, String sqlUid){
        this.baseMapper.generateAirlineYearReport(getAirlineYearReportDTO.getYear(), sqlUid);

        return this.baseMapper.getAirlineYearReport();
    }

    @Override
    public Map<String, Object> cityReport(GetCityReportDTO getCityReportDTO, String sqlUid){
        this.baseMapper.generateCityReport(getCityReportDTO.getYear(), sqlUid);

        Map<String, Object> r = new HashMap<>();
        r.put("pair", this.baseMapper.getCityPairReport());
        r.put("arrive", this.baseMapper.getCityArriveReport());
        r.put("dept", this.baseMapper.getCityDeptReport());
        return r;
    }

    @Override
    public Map<String, Object> userYearReport(GetUserYearReportDTO getUserYearReportDTO, String sqlUid){
        this.baseMapper.generateUserYearReport(getUserYearReportDTO.getYear(),
                getUserYearReportDTO.getUserId(),
                sqlUid);
        Map<String, Object> r = new HashMap<>();
        r.put("yearReport", this.baseMapper.getUserReport());
        r.put("tripReport", this.baseMapper.getUserTripReport());
        r.put("airlineOrderReport", this.baseMapper.getUserAirlineOrderReport());

        return r;
    }

    @Override
    public String graph(GetGraphDTO getGraphDTO){
        List<GraphDTO> r = this.baseMapper.getGraph(getGraphDTO.getStartDate(), getGraphDTO.getEndDate());
        StringBuilder sb = new StringBuilder();
        sb.append(r.get(0).getGraph());
        r.remove(0);
        for (GraphDTO g: r) {
            sb.append(",");
            sb.append(g.getGraph());
        }

        return sb.toString().replaceAll("BJS", "PEK");
    }
}
