package com.gc.inmemorydb.core.dto.system.role;

import com.gc.inmemorydb.core.dto.SplitPageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Licoy
 * @version 2018/4/19/9:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FindRoleDTO extends SplitPageDTO {

    private Boolean hasResource = true;

}
