package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gc.inmemorydb.core.dto.system.flight.FindTicketDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZWZ
 * @version 2018/12/9/14:18
 */
@Mapper
@Repository
public interface FlightMapper extends BaseMapper<Flight> {
    List<Flight> findCertainFlightSQL(Pagination page, @Param("deptDate") String deptDate);
}
