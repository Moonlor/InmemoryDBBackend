package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gc.inmemorydb.core.entity.system.Airport;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ZWZ
 * @version 2018/12/10/15:10
 */
@Mapper
@Repository
public interface AirportMapper extends BaseMapper<Airport> {
}
