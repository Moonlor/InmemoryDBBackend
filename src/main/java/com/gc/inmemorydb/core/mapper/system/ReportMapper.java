package com.gc.inmemorydb.core.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gc.inmemorydb.core.dto.system.report.*;
import com.gc.inmemorydb.core.entity.system.Flight;
import com.gc.inmemorydb.core.entity.system.Report;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReportMapper extends BaseMapper<Flight> {

    List<CertainAirlineReportDTO> generateCertainAirlineReport(@Param("year") Integer year,
                                                               @Param("airline") String airline,
                                                               @Param("sqlUid") String sqlUid);
    List<CertainAirlineReportDTO> getCertainAirlineReport();

    List<AirlineYearReportDTO> generateAirlineYearReport(@Param("year") Integer year,
                                                         @Param("sqlUid") String sqlUid);
    List<AirlineYearReportDTO> getAirlineYearReport();

    List<AirlineYearReportDTO> generateCityReport(@Param("year") Integer year,
                                                  @Param("sqlUid") String sqlUid);
    List<CityPairReportDTO> getCityPairReport();
    List<CityArriveReportDTO> getCityArriveReport();
    List<CityDeptReportDTO> getCityDeptReport();

    List<UserReportDTO> generateUserYearReport(@Param("year") Integer year,
                                               @Param("userId") String userId,
                                               @Param("sqlUid") String sqlUid);
    List<UserReportDTO> getUserReport();
    List<UserTripDTO> getUserTripReport();
    List<UserAirlineOrderDTO> getUserAirlineOrderReport();

    List<GraphDTO> getGraph(@Param("startDate") String startDate,
                         @Param("endDate") String endDate);
}
