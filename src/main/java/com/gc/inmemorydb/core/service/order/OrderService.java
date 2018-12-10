package com.gc.inmemorydb.core.service.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;


/**
 * @author STY
 * @version 2018/12/9/14:15
 */
public interface OrderService {

    /**
     * 获取机票列表
     * @return
     * */
    Page<Flight> findCertainFlight(FindTicketDTO findTicketDTO);
}
