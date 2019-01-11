package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;

@Data
public class CityPairReportDTO extends SplitPageDTO {

    private Integer year;

    private String cityDept;

    private String cityArrive;

    private Integer flightNumber;
}
