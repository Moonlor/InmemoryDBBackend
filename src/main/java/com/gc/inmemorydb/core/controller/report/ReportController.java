package com.gc.inmemorydb.core.controller.report;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.StaticCache;
import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.dto.system.report.CertainAirlineReportDTO;
import com.gc.inmemorydb.core.dto.system.report.GetCertainAirlineReportDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.service.Flight.TicketService;
import com.gc.inmemorydb.core.service.Report.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/report")
@Api(tags = {"获取报告"})
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(value = {"/certainAirlineReport"})
    @ApiOperation(value = "生成某个航空公司的年度报表")
    @SysLogs("生成某个航空公司的年度报表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult get(@RequestBody GetCertainAirlineReportDTO getCertainAirlineReportDTO) {
        String sqlUid = UUID.randomUUID().toString();
        List<CertainAirlineReportDTO> results = reportService.certainAirlineReport(getCertainAirlineReportDTO, sqlUid);
        return ResponseResult.e(ResponseCode.OK, results, StaticCache.getSqlCostUid(sqlUid));
    }
}
