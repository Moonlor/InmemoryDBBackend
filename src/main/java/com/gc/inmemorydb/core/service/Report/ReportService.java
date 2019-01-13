package com.gc.inmemorydb.core.service.Report;

import com.gc.inmemorydb.core.dto.system.report.*;

import java.util.List;
import java.util.Map;


public interface ReportService {

    List<CertainAirlineReportDTO> certainAirlineReport(GetCertainAirlineReportDTO getCertainAirlineReportDTO, String sqlUid);

    List<AirlineYearReportDTO> airlineYearReport(GetAirlineYearReportDTO getAirlineYearReportDTO, String sqlUid);

    Map<String, Object> cityReport(GetCityReportDTO getCityReportDTO, String sqlUid);

    Map<String, Object> userYearReport(GetUserYearReportDTO getUserYearReportDTO, String sqlUid);

    String graph(GetGraphDTO getGraphDTO);
}
