package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;

@Data
public class CityDeptReportDTO extends SplitPageDTO {

    private Integer year;

    private String city;

    private Integer orderNumber;
}
