package com.gc.inmemorydb.core.entity.system;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import java.io.Serializable;


@Data
public class Ticketorder implements Serializable {


    private Integer orderId;

    private String userId;

    private Integer flightId;

    private String  status;
}
