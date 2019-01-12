package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class AirlineYearReportDTO extends SplitPageDTO {

    private String Airline;

    private Integer flightNumber;

    private Integer totalInput;

    private Integer year;

}
