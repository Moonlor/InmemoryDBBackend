package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserReportDTO extends SplitPageDTO {

    private Integer year;

    private String userId;

    private Integer orderNum;

    private Integer cityNum;

    private String mostDeptCity;

    private String mostArriveCity;

    private Integer flyHour;

    private String mostCity;

    private Integer mostNum;
}
