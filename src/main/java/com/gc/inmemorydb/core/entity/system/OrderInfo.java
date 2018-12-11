package com.gc.inmemorydb.core.entity.system;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;


@Data
public class OrderInfo implements Serializable {

    private Integer orderId;

    private Integer flightId;

    private String  arriveAirport;

    private String deptAirport;

    private Date arriveDate;

    private Date deptDate;

    private Integer price;
}
