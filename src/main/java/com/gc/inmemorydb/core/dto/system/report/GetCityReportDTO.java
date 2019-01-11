package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class GetCityReportDTO extends SplitPageDTO {

    @NotBlank(message = "年份不能为空")
    private Integer year;
}
