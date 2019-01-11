package com.gc.inmemorydb.core.service.Report.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.report.CertainAirlineReportDTO;
import com.gc.inmemorydb.core.dto.system.report.GetCertainAirlineReportDTO;
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
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Flight> implements ReportService {

    @Autowired
    private ShiroService shiroService;

    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<CertainAirlineReportDTO> certainAirlineReport(GetCertainAirlineReportDTO getCertainAirlineReportDTO, String sqlUid) {
        return this.baseMapper.getCertainAirlineReport(getCertainAirlineReportDTO.getYear(),
                getCertainAirlineReportDTO.getAirline(),
                sqlUid);
    }
}
