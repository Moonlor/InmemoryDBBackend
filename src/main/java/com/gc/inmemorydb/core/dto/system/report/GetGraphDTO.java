package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


@Data
public class GetGraphDTO{

    @NotBlank(message = "开始时间不能为空")
    private String startDate;

    @NotBlank(message = "结束时间不能为空")
    private String endDate;

}
