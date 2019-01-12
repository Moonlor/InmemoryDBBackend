package com.gc.inmemorydb.core.dto.system.report;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;

@Data
public class UserTripDTO extends SplitPageDTO {

    private Integer year;

    private String userId;

    private String city;

    private Integer times;

    private String isDept;
}
