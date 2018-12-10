package com.gc.inmemorydb.core.dto.system.order;

import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;


/**
 * @author STY
 * @version 2018/12/11
 */
@Data
public class OrderAddDTO {
    @NotBlank(message = "航班号不能为空")
    private Integer flightId;

}
