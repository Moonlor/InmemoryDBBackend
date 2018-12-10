package com.gc.inmemorydb.core.dto.system.flight;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class ModifyFlightDTO extends SplitPageDTO {

    @NotBlank(message = "航班id不能为空")
    private Integer id;

    @NotBlank(message = "航班状态不能为空")
    private String state;
}
