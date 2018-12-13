package com.gc.inmemorydb.core.service.Flight;

import com.baomidou.mybatisplus.plugins.Page;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author ZWZ
 * @version 2018/12/9/14:15
 */
public interface TicketService {

    /**
     * 获取机票列表
     * @return
     * */
    Page<Flight> findCertainFlight(FindTicketDTO findTicketDTO, String sqlUid);
}
