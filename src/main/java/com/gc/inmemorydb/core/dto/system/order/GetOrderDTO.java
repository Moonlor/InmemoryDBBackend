package com.gc.inmemorydb.core.dto.system.order;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;


/**
 * @author STY
 * @version 2018/12/11
 */
@Data
public class GetOrderDTO{

    private Integer page;

    private Integer pageSize;

}
