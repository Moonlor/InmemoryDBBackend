package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gc.inmemorydb.core.entity.system.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ZWZ
 * @version 2018/12/9/14:18
 */
@Mapper
@Repository
public interface FlightMapper extends BaseMapper<Flight> {
}
