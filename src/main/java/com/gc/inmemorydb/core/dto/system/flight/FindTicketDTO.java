package com.gc.inmemorydb.core.dto.system.flight;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ZWZ
 * @version 2018/12/9
 */
@Data
public class FindTicketDTO {

    @NotBlank(message = "出发城市不能为空")
    private String deptCity;

    @NotBlank(message = "抵达城市不能为空")
    private String arriveCity;

    @NotBlank(message = "出发时间不能为空")
    private String deptDate;
}
