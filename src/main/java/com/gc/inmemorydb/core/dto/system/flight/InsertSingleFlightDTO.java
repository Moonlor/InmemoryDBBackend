package com.gc.inmemorydb.core.dto.system.flight;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
public class InsertSingleFlightDTO extends SplitPageDTO {

    @NotBlank(message = "航班号不能为空")
    private String flightCode;

    private Date deptDate;

    private String deptTime;

    private Date arriveDate;

    private String arriveTime;

    private Integer price;

    private String airline;

    private String state;

    private String arriveAirportCode;

    private String deptAirportCode;
}
