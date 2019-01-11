package com.gc.inmemorydb.core.service.Report;

import com.gc.inmemorydb.core.dto.system.report.CertainAirlineReportDTO;
import com.gc.inmemorydb.core.dto.system.report.GetCertainAirlineReportDTO;

import java.util.List;


public interface ReportService {

    List<CertainAirlineReportDTO> certainAirlineReport(GetCertainAirlineReportDTO getCertainAirlineReportDTO, String sqlUid);
}
