package com.gc.inmemorydb.core.controller.ticket;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.StaticCache;
import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.service.Flight.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author ZWZ
 * @version 2018/12/9/13:48
 */
@RestController
@RequestMapping(value = "/ticket")
@Api(tags = {"机票查询"})
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping(value = {"/get"})
    @ApiOperation(value = "获取特定航班信息")
    @SysLogs("获取特定航班信息")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult get(@RequestBody FindTicketDTO findTicketDTO) {
        String sqlUid = UUID.randomUUID().toString();
        Page<Flight> results = ticketService.findCertainFlight(findTicketDTO, sqlUid);
        return ResponseResult.e(ResponseCode.OK, results, StaticCache.getSqlCostUid(sqlUid));
    }
}
