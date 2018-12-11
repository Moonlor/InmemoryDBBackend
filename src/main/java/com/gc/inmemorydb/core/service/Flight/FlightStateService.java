package com.gc.inmemorydb.core.service.Flight;

import com.gc.inmemorydb.core.dto.system.flight.*;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

public interface FlightStateService {

    /**
     * 获取航班状态信息
     * @return
     **/
    Page<Flight> getFlightStatus(GetFlightStateDTO getFlightStateDTO);

    Boolean modifyFlightState(ModifyFlightDTO modifyFlightDTO);

    Boolean modifyFlightInfo(ModifyFlightDTO modifyFlightDTO);

    Boolean insertSingleFlight(InsertSingleFlightDTO insertSingleFlightDTO);

    Flight searchFlightById(SearchFlightDTO searchFlightDTO);

    List<Map<String, Object>> reportAirlineFlightNumber(ReportDTO reportDTO);

}
