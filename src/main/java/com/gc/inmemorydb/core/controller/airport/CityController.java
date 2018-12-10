package com.gc.inmemorydb.core.controller.airport;

import com.gc.inmemorydb.common.annotation.SysLogs;
import com.gc.inmemorydb.common.bean.ResponseCode;
import com.gc.inmemorydb.common.bean.ResponseResult;
import com.gc.inmemorydb.core.dto.system.airport.GetAllCityDTO;
import com.gc.inmemorydb.core.entity.system.Airport;
import com.gc.inmemorydb.core.service.Airport.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZWZ
 * @version 2018/12/10/15:18
 */
@RestController
@RequestMapping(value = "/city")
@Api(tags = {"城市查询"})
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(value = {"/getAll"})
    @ApiOperation(value = "获取城市列表")
    @SysLogs("获取指定城市列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult get() {
        List<Airport> results = cityService.getAllCity();
        List<String> citynames = new ArrayList<>();
        for(Airport a : results) {
            if(!citynames.contains(a.getCityName()))
                citynames.add(a.getCityName());
        }

        return ResponseResult.e(ResponseCode.OK, citynames);
    }
}
