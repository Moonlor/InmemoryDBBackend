package com.gc.inmemorydb.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class Order implements Serializable {

    @TableId
    private Integer orderId;

    private String flightCode;

    private String arriveAirportCode;

    private String deptAirportCode;

    private Date deptDate;

    private String deptTime;

    private Integer price;

    private Date createTime;

    private String status;
}
