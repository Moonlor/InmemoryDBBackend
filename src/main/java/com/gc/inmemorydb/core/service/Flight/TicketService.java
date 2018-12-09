package com.gc.inmemorydb.core.service.Flight;

import com.baomidou.mybatisplus.service.IService;
import com.gc.inmemorydb.common.service.QueryService;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;

import java.util.Date;
import java.util.List;

/**
 * @author ZWZ
 * @version 2018/12/9/14:15
 */
public interface TicketService extends IService<Flight> {

    /**
     * 获取机票列表
     * @return
     * */
    List<Flight> findCertainFlight(FindTicketDTO findTicketDTO);
}
