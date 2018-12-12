package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.entity.system.Report;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ZWZ
 * @version 2018/12/9/14:18
 */
@Mapper
@Repository
public interface FlightMapper extends BaseMapper<Flight> {
    List<Flight> findCertainFlightSQL(Pagination page,
                                      @Param("deptDate") String deptDate,
                                      @Param("deptCity") String deptCity,
                                      @Param("arriveCity") String arriveCity);
    List<Map<String, Object>> reportAirlineFlightNumber();


    List<Report> reportAirlineCityNumber();
}
