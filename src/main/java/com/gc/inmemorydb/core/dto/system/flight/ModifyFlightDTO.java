package com.gc.inmemorydb.core.dto.system.flight;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
public class ModifyFlightDTO extends SplitPageDTO {

    @NotBlank(message = "航班id不能为空")
    private Integer flightId;

    private Date deptDate;

    private String deptTime;

    private Date arriveDate;

    private String arriveTime;

    private Integer price;

    private String status

    private String arriveAirportCode;

    private String deptAirportCode;

}
