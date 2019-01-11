package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;

@Data
public class CertainAirlineReportDTO extends SplitPageDTO {

    private String year;

    private String airline;

    private String city;

    private String flightNumber;

    private String passengerNumber;

    private String totalInput;
}
