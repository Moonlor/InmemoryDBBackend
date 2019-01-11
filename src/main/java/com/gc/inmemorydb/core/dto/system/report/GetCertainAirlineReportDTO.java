package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class GetCertainAirlineReportDTO extends SplitPageDTO {

    @NotBlank(message = "年份不能为空")
    private Integer year;

    @NotBlank(message = "航空公司不能为空")
    private String airline;

}
