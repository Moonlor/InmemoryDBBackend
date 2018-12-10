package com.gc.inmemorydb.core.service.Airport;

import com.gc.inmemorydb.core.dto.system.airport.GetAllCityDTO;
import com.gc.inmemorydb.core.entity.system.Airport;

import java.util.List;

/**
 * @author ZWZ
 * @version 2018/12/10/15:23
 */
public interface CityService {

    /**
     * 获取城市列表
     * @return
     * */
    List<Airport> getAllCity();
}
