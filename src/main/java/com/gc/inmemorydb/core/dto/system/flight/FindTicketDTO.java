package com.gc.inmemorydb.core.dto.system.flight;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ZWZ
 * @version 2018/12/9
 */
@Data
public class FindTicketDTO extends SplitPageDTO {

    @NotBlank(message = "出发城市不能为空")
    private String deptCity;

    @NotBlank(message = "抵达城市不能为空")
    private String arriveCity;

    @NotBlank(message = "出发时间不能为空")
    private String deptDate;


}
