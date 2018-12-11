package com.gc.inmemorydb.core.controller.flight;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.core.dto.system.flight.*;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.service.Flight.FlightStateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/flight")
@Api(tags = {"航班状态"})
public class FlightController {

    @Autowired
    private FlightStateService flightStateService;

    @PostMapping(value = {"/list"})
    @ApiOperation(value = "获取航班状态")
    @SysLogs("获取航班状态")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult list(@RequestBody GetFlightStateDTO getFlightStateDTO){
        Page<Flight> results = flightStateService.getFlightStatus(getFlightStateDTO);
        return ResponseResult.e(ResponseCode.OK, results);
    }

    @PostMapping(value = {"/modify/state"})
    @ApiOperation(value = "修改航班状态")
    @SysLogs("修改航班状态")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult modify(@RequestBody ModifyFlightDTO modifyFlightDTO){
        Boolean result = flightStateService.modifyFlightState(modifyFlightDTO);
        return ResponseResult.e(ResponseCode.OK, result);
    }

    @PostMapping(value = {"/modify/info"})
    @ApiOperation(value = "修改航班信息")
    @SysLogs("修改航班信息")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult modifyInfo(@RequestBody ModifyFlightDTO modifyFlightDTO){
        Boolean result = flightStateService.modifyFlightInfo(modifyFlightDTO);
        return ResponseResult.e(ResponseCode.OK, result);
    }

    @PostMapping(value = {"/add/single"})
    @ApiOperation(value = "添加航班信息")
    @SysLogs("添加航班信息")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult add(@RequestBody InsertSingleFlightDTO insertSingleFlightDTO){
        Boolean result = flightStateService.insertSingleFlight(insertSingleFlightDTO);
        return ResponseResult.e(ResponseCode.OK, result);
    }

    @PostMapping(value = {"/searchById"})
    @ApiOperation(value = "根据Id查找航班")
    @SysLogs("根据Id查找航班")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult searchById(@RequestBody SearchFlightDTO searchFlightDTO){
        Flight result = flightStateService.searchFlightById(searchFlightDTO);
        return ResponseResult.e(ResponseCode.OK, result);
    }

    @PostMapping(value = {"/report"})
    @ApiOperation(value = "报表")
    @SysLogs("报表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult report(@RequestBody ReportDTO reportDTO){
        List<Map<String, Object>> result = flightStateService.reportAirlineFlightNumber(reportDTO);
        return ResponseResult.e(ResponseCode.OK, result);
    }

}
