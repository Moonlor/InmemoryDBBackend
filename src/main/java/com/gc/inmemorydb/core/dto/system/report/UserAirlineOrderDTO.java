package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;

@Data
public class UserAirlineOrderDTO extends SplitPageDTO {

    private Integer year;

    private String userId;

    private String airline;

    private Integer orderNum;

    private Integer orderMoney;
}
