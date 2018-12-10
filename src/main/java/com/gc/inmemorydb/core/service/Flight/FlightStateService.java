package com.gc.inmemorydb.core.service.Flight;

import com.gc.inmemorydb.core.dto.system.flight.GetFlightStateDTO;
import com.gc.inmemorydb.core.dto.system.flight.InsertSingleFlightDTO;
import com.gc.inmemorydb.core.dto.system.flight.ModifyFlightDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.baomidou.mybatisplus.plugins.Page;

public interface FlightStateService {

    /**
     * 获取航班状态信息
     * @return
     **/
    Page<Flight> getFlightStatus(GetFlightStateDTO getFlightStateDTO);

    Boolean modifyFlightState(ModifyFlightDTO modifyFlightDTO);

    Boolean modifyFlightInfo(ModifyFlightDTO modifyFlightDTO);

    Boolean insertSingleFlight(InsertSingleFlightDTO insertSingleFlightDTO);

}
