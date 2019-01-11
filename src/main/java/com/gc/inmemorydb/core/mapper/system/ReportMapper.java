package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gc.inmemorydb.core.dto.system.report.CertainAirlineReportDTO;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.entity.system.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReportMapper extends BaseMapper<Flight> {

    List<CertainAirlineReportDTO> getCertainAirlineReport(@Param("year") Integer year,
                                                          @Param("airline") String airline,
                                                          @Param("sqlUid") String sqlUid);
}
