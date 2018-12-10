package com.gc.inmemorydb.core.service.Airport.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gc.inmemorydb.core.dto.system.airport.GetAllCityDTO;
import com.gc.inmemorydb.core.entity.system.Airport;
import com.gc.inmemorydb.core.mapper.system.AirportMapper;
import com.gc.inmemorydb.core.service.Airport.CityService;
import com.gc.inmemorydb.core.service.global.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl extends ServiceImpl<AirportMapper, Airport> implements CityService {

    @Autowired
    private ShiroService shiroService;

    public List<Airport> getAllCity() {
        EntityWrapper<Airport> wrapper = new EntityWrapper<>();
        return selectList(wrapper);
    }
}
