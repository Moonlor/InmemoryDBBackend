package com.gc.inmemorydb.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZWZ
 * @version 2018/12/9/13:51
 */
@Data

public class Flight implements Serializable {

    @TableId
    private Integer flightId;

    private String flightCode;

    private Date deptDate;

    private String deptTime;

    private Date arriveDate;

    private String arriveTime;

    private Integer price;

    private String status;

    private String airline;

    private String arriveAirportCode;

    private String deptAirportCode;
}
